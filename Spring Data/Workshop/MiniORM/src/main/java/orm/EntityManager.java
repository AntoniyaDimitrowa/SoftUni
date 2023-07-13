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
import java.util.*;
import java.util.stream.Collectors;

public class EntityManager<E> implements DBContext<E> {
    private static final String INSERT_QUERY_FORMAT = "INSERT INTO %s(%s)VALUES (%s);";
    private static final String UPDATE_QUERY_BY_ID_FORMAT = "UPDATE %s SET %s WHERE ID = %d;";
    private static final String FIND_FIRST_QUERY_FORMAT = "SELECT * FROM %s %s LIMIT 1;";
    private static final String FIND_ALL_QUERY_FORMAT = "SELECT * FROM %s %s;";
    private static final String CREATE_TABLE_QUERY_FORMAT = "CREATE TABLE `%s` (`id` INT PRIMARY KEY AUTO_INCREMENT, %s); ";
    private static final String CREATE_COLUMN_NAME_AND_TYPE_FORMAT = "`%s` %s";
    private static final String ALTER_TABLE_QUERY = "ALTER TABLE `%s` ADD COLUMN %s;";
    private static final String GET_ALL_COLUMN_NAMES_BY_TABLE_NAME_QUERY = "SELECT `COLUMN_NAME`\n" +
            "FROM information_schema.COLUMNS\n" +
            "WHERE TABLE_SCHEMA == `custom_orm_workshop`\n" +
            "AND COLUMN_NAME != `id`\n" +
            "AND TABLE_NAME = ?";


    private static final String ID_COLUMN_MISSING_MESSAGE = "Entity missing an Id column";
    private static final String CLASS_MUST_BE_ENTITY_MESSAGE = "Class must be Entity";
    private static final String COMMA_SEPARATOR = ", ";

    private static final String WHERE_KEY_WORD = "WHERE ";


    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        final Field idField = getIdField(entity.getClass());
        idField.setAccessible(true);
        final Object idValue = idField.get(entity);

        if(idValue == null || (int) idValue <= 0) {
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

        final String tableName = getTableName(table);
        final String actualWhere = where == null ? "" : WHERE_KEY_WORD + where;

        final String query = String.format(FIND_ALL_QUERY_FORMAT, tableName, actualWhere);

        final PreparedStatement statement = connection.prepareStatement(query);
        final ResultSet resultSet = statement.executeQuery();

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
        final String tableName = getTableName(table);
        final String actualWhere = where == null ? "" : WHERE_KEY_WORD + where;

        final String query = String.format(FIND_FIRST_QUERY_FORMAT, tableName, actualWhere);

        final PreparedStatement statement = connection.prepareStatement(query);
        final ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()) {
            return createEntity(table, resultSet);
        }

        return null;
    }

    @Override
    public void createTable(Class<E> entityClass) throws SQLException {
        final String tableName = getTableName(entityClass);

        final String finalQuery = String.format(CREATE_TABLE_QUERY_FORMAT, tableName, getAllFieldsAndDataTypes(entityClass));
        connection.prepareStatement(finalQuery).execute();
    }

    @Override
    public void alterTable(Class<E> entityClass) throws SQLException {
        final String tableName = getTableName(entityClass);

        addColumnStatementForNewFields(entityClass, tableName);

        final String finalQuery = String.format(ALTER_TABLE_QUERY, tableName, getNewFields(entityClass));
        connection.prepareStatement(finalQuery).executeUpdate();
    }

    private void addColumnStatementForNewFields(Class<E> entityClass, String tableName) throws SQLException {
        final Set<String> sqlColumnNames = getSQLColumnNames(tableName);
        final List<Field> allFieldsWithoutId = getAllFieldsWithoutId(entityClass);

        ArrayList<String> nonMatchingFields = new ArrayList<>();

        for (Field field : allFieldsWithoutId) {
            final String columnName = getSqlName(field);

            if (sqlColumnNames.contains(columnName)) continue;

            final String columnType = getSQLDataType(field.getType());
        }
    }

    private Set<String> getSQLColumnNames(String tableName) throws SQLException {
        Set<String> allFields = new HashSet<>();


        final PreparedStatement statement = connection.prepareStatement(GET_ALL_COLUMN_NAMES_BY_TABLE_NAME_QUERY);
        statement.setString(1, tableName);

        final ResultSet allFieldsResultSet = statement.executeQuery();

        while (allFieldsResultSet.next()) {
            allFields.add(allFieldsResultSet.getString(1));
        }

        return allFields;
    }

    private String getAllFieldsAndDataTypes(Class<E> entityClass) {
        StringBuilder result = new StringBuilder();
        getAllFieldsWithoutId(entityClass)
                .stream()
                .forEach(f -> {
                    result.append(getSQLNameAndDataTypeOfField(f)).append(COMMA_SEPARATOR);
                });
        return result.substring(0, result.length() - 2);
    }

    private String getSQLNameAndDataTypeOfField(Field f) {
        return String.format(CREATE_COLUMN_NAME_AND_TYPE_FORMAT, getSqlName(f), getSQLDataType(f.getType()));
    }

    private String getSqlName(Field f) {
        return f.getAnnotationsByType(Column.class)[0].name();
    }

    private String getSQLDataType(Class<?> fieldType) {
        if(fieldType == Integer.class || 
                fieldType == int.class || 
                fieldType == long.class || 
                fieldType == Long.class) {
            return "INT";
        } else if (fieldType == LocalDate.class) {
            return "DATE";
        }

        return "VARCHAR(100)";
    }

    private List<Field> getAllFieldsWithoutId(Class<E> entityClass) {
        return Arrays.stream(entityClass.getDeclaredFields())
                .filter(f -> !f.isAnnotationPresent(Id.class) && f.isAnnotationPresent(Column.class))
                .collect(Collectors.toList());
    }

    private E createEntity(Class<E> table, ResultSet resultSet) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final E entity = table.getDeclaredConstructor().newInstance();

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

        final String fieldName = field.getAnnotation(Column.class).name();

        final Class<?> fieldType = field.getType();

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
        final String tableName = getTableName(entity.getClass());
        final String fieldNamesWithoutId = getFieldNamesWithoutId(entity.getClass());
        final String fieldValuesWithoutId = getFieldValuesWithoutId(entity);

        final String query = String.format(INSERT_QUERY_FORMAT, tableName, fieldNamesWithoutId, fieldValuesWithoutId);

        final PreparedStatement statement = this.connection.prepareStatement(query);

        return statement.executeUpdate() == 1;
    }

    private boolean updateEntity(E entity, Object id) throws SQLException {
        final String tableName = getTableName(entity.getClass());
        final String fieldNamesWithoutIdString = getFieldNamesWithoutId(entity.getClass());
        final String fieldValuesWithoutIdString = getFieldValuesWithoutId(entity);

        final List<String> fieldNamesWithoutId = Arrays.stream(fieldNamesWithoutIdString.split(",")).collect(Collectors.toList());
        final List<String> fieldValuesWithoutId = Arrays.stream(fieldValuesWithoutIdString.split(",")).collect(Collectors.toList());

        StringBuilder sbForSettingValues = new StringBuilder();

        for (int i = 0; i < fieldNamesWithoutId.size(); i++) {
            final String currFieldName = fieldNamesWithoutId.get(i);
            final String currFieldValue = fieldValuesWithoutId.get(i);

            if(i == 0) {
                sbForSettingValues.append(currFieldName).append(" = ").append(currFieldValue);
            }
            sbForSettingValues.append(", ").append(currFieldName).append(" = ").append(currFieldValue);
        }

        final String query = String.format(UPDATE_QUERY_BY_ID_FORMAT, tableName, sbForSettingValues, id);

        final PreparedStatement statement = this.connection.prepareStatement(query);

        return statement.executeUpdate() == 1;
    }

    private String getFieldValuesWithoutId(E entity) {
        final Field idField = getIdField(entity.getClass());

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
        final Field idField = getIdField(entityClass);

        return Arrays.stream(entityClass.getDeclaredFields())
                .filter(f -> !f.getName().equals(idField.getName()))
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(f -> f.getAnnotation(Column.class).name())
                .collect(Collectors.joining(","));
    }

    private String getTableName(Class<?> entityClass) {
        final Entity annotation = entityClass.getAnnotation(Entity.class);

        if(annotation == null) {
            throw new UnsupportedOperationException(CLASS_MUST_BE_ENTITY_MESSAGE);
        }

        return annotation.name();
    }

    private Field getIdField(Class<?> entityClass) {
        final Field[] declaredFields = entityClass.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(Id.class)) {
                return declaredField;
            }
        }

        throw new UnsupportedOperationException(ID_COLUMN_MISSING_MESSAGE);
    }
}
