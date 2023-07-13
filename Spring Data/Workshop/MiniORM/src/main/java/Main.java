import entities.Account;
import orm.EntityManager;
import orm.config.MyConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        MyConnector.createConnection("root", "12345", "custom_orm_workshop");

        Connection connection = MyConnector.getConnection();

        EntityManager<Account> accountEntityManager = new EntityManager<>(connection);
        accountEntityManager.createTable(Account.class);
        accountEntityManager.alterTable(Account.class);

        /*User user1 = new User("Antonia", "12345", 19, LocalDate.now());
        user1.setId(1);

        EntityManager<User> userEntityManager = new EntityManager<>(connection);
        boolean persistResult = userEntityManager.persist(user1);

        User first = userEntityManager.findFirst(User.class);
        System.out.println(first);

        System.out.println();

        System.out.println(persistResult);*/
    }
}
