import java.sql.*;
import java.util.Scanner;

public class IncreaseAgeStoredProcedure {
    private static final String GET_OLDER_PROCEDURE = "{CALL usp_get_older (?)}";
    private static final String QUERY_FOR_FINDING_MINION_NAME_AND_AGE_BY_ID = "SELECT m.name, m.age FROM minions_db.`minions` AS m WHERE id = ?";
    private static final String LABEL_FOR_MINION = "%s %d%n";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        final int minionId = scanner.nextInt();

        final Connection connection = Utils.getSQLConnection();

        final CallableStatement getOlderStoredProcedure = connection.prepareCall(GET_OLDER_PROCEDURE);
        getOlderStoredProcedure.setInt(1, minionId);
        getOlderStoredProcedure.execute();

        final PreparedStatement minionsStatement = connection.prepareStatement(QUERY_FOR_FINDING_MINION_NAME_AND_AGE_BY_ID);
        minionsStatement.setInt(1, minionId);

        final ResultSet minions = minionsStatement.executeQuery();
        minions.next();

        System.out.printf(LABEL_FOR_MINION,
                minions.getString(Constants.COLUMN_LABEL_NAME),
                minions.getInt(Constants.COLUMN_LABEL_AGE));
    }
}

