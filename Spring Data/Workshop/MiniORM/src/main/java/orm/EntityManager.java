package orm;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EntityManager<E> implements DBContext<E> {

    private static final String INSERT_QUERY = "INSERT INTO %s(%s)VALUES (%s);";
    private static final String UPDATE_QUERY = "UPDATE %s SET %s WHERE %s;";
    private static final String SELECT_QUERY_SINGLE = "SELECT * FROM %s %s %s LIMIT 1;";
    private static final String SELECT_QUERY = "SELECT * FROM %s %s %s;";


    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field idField = getIdField(entity.getClass());
        idField.setAccessible(true);
        Object idValue = idField.get(entity);

        if(idValue == null || (int) idValue == 0) {
            return insertEntity(entity);
        }

        return updateEntity(entity, idValue);
    }

    @Override
    public Iterable<E> find(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return find(table, null);
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<E> listOfEntities = new ArrayList<>();

        String tableName = getTableName(table);
        String actualWhere = where == null ? "" : where;

        String query = String.format(SELECT_QUERY, tableName, actualWhere);

        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            listOfEntities.add(createEntity(table, resultSet));
        }

        return listOfEntities;
    }

    @Override
    public E findFirst(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return findFirst(table, null);
    }

    @Override
    public E findFirst(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String tableName = getTableName(table);
        String actualWhere = where == null ? "" : where;

        String query = String.format(SELECT_QUERY_SINGLE, tableName, actualWhere);

        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()) {
            return createEntity(table, resultSet);
        }

        return null;
    }

    private E createEntity(Class<E> table, ResultSet resultSet) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        E entity = table.getDeclaredConstructor().newInstance();

        Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class))
                .forEach(f -> {
                    try {
                        fillData(entity, f, resultSet);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });

        return entity;
    }

    private void fillData(E entity, Field field, ResultSet resultSet) throws SQLException, IllegalAccessException {
        field.setAccessible(true);

        String fieldName = field.getAnnotation(Column.class).name();

        Class<?> fieldType = field.getType();

        Object value;
        if (fieldType == int.class) {
            value = resultSet.getInt(fieldName);
        } else if (fieldType == LocalDate.class) {
            String stringDate = resultSet.getString(fieldName);
            value = LocalDate.parse(stringDate );
        } else {
            value = resultSet.getString(fieldName);
        }

        field.set(entity, value);
    }

    private boolean insertEntity(E entity) throws SQLException {
        String tableName = getTableName(entity.getClass());
        String fieldNamesWithoutId = getFieldNamesWithoutId(entity.getClass());
        String fieldValuesWithoutId = getFieldValuesWithoutId(entity);

        String query = String.format(INSERT_QUERY, tableName, fieldNamesWithoutId, fieldValuesWithoutId);

        PreparedStatement statement = this.connection.prepareStatement(query);

        return statement.executeUpdate() == 1;
    }

    private boolean updateEntity(E entity, Object id) throws SQLException {
        String tableName = getTableName(entity.getClass());
        String fieldNamesWithoutIdString = getFieldNamesWithoutId(entity.getClass());
        String fieldValuesWithoutIdString = getFieldValuesWithoutId(entity);

        List<String> fieldNamesWithoutId = Arrays.stream(fieldNamesWithoutIdString.split(",")).collect(Collectors.toList());
        List<String> fieldValuesWithoutId = Arrays.stream(fieldValuesWithoutIdString.split(",")).collect(Collectors.toList());

        StringBuilder sbForSettingValues = new StringBuilder();

        for (int i = 0; i < fieldNamesWithoutId.size(); i++) {
            String currFieldName = fieldNamesWithoutId.get(i);
            String currFieldValue = fieldValuesWithoutId.get(i);

            if(i == 0) {
                sbForSettingValues.append(currFieldName).append(" = ").append(currFieldValue);
            }
            sbForSettingValues.append(", ").append(currFieldName).append(" = ").append(currFieldValue);
        }

        String query = String.format(UPDATE_QUERY, tableName, sbForSettingValues, id);

        PreparedStatement statement = this.connection.prepareStatement(query);

        return statement.executeUpdate() == 1;
    }

    private String getFieldValuesWithoutId(E entity) {
        Field idField = getIdField(entity.getClass());

        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(f -> !f.getName().equals(idField.getName()))
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(f -> {
                    f.setAccessible(true);
                    try {
                        Object value = f.get(entity);
                        return String.format("'%s'", value.toString());
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.joining(","));
    }

    private String getFieldNamesWithoutId(Class<?> entityClass) {
        Field idField = getIdField(entityClass);

        return Arrays.stream(entityClass.getDeclaredFields())
                .filter(f -> !f.getName().equals(idField.getName()))
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(f -> f.getAnnotation(Column.class).name())
                .collect(Collectors.joining(","));
    }

    private String getTableName(Class<?> entityClass) {
        Entity annotation = entityClass.getAnnotation(Entity.class);

        if(annotation == null) {
            throw new UnsupportedOperationException("Entity must have Entity annotation");
        }

        return annotation.name();
    }

    private Field getIdField(Class<?> entityClass) {
        Field[] declaredFields = entityClass.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(Id.class)) {
                return declaredField;
            }
        }

        throw new UnsupportedOperationException("Entity does not have ID column");
    }
}
