import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetMinionNames {
    private static final String GET_MINIONS_NAME_AND_AGE_WORKING_FOR_VILLAIN =
            "SELECT m.`name`, m.`age` " +
            "FROM `minions` AS m " +
            "WHERE m.`id` IN (SELECT mv.`minion_id` " +
                            "FROM `minions_villains` AS mv " +
                            "WHERE mv.`villain_id` = ?);";

    private static final String GET_VILLAIN_NAME_BY_ID = "SELECT `name` FROM `villains` WHERE `id` = ?;";
    private static final String FORMAT_IF_VILLAIN_DOES_NOT_EXIST = "No villain with ID %d exists in the database.";
    private static final String VILLAIN_FORMAT = "Villain: %s";
    private static final String MINION_FORMAT = "%d. %s %d";

    public static void main(String[] args) throws SQLException {
        final Connection sqlConnection = Utils.getSQLConnection();

        Scanner scanner = new Scanner(System.in);
        int villainId = Integer.parseInt(scanner.nextLine());

        final PreparedStatement statementForVillain = sqlConnection.prepareStatement(GET_VILLAIN_NAME_BY_ID);
        statementForVillain.setInt(1, villainId);

        final ResultSet resultSetVillain = statementForVillain.executeQuery();
        if(!resultSetVillain.next()) {
            System.out.printf(FORMAT_IF_VILLAIN_DOES_NOT_EXIST, villainId);
        } else {
            System.out.printf(VILLAIN_FORMAT, resultSetVillain.getString("name"));
            System.out.println();
            final PreparedStatement statementForMinions = sqlConnection.prepareStatement(GET_MINIONS_NAME_AND_AGE_WORKING_FOR_VILLAIN);
            statementForMinions.setInt(1, villainId);

            final ResultSet resultSetMinion = statementForMinions.executeQuery();
            for (int index = 1; resultSetMinion.next(); index++) {
                final String minionName = resultSetMinion.getString(1);
                final int minionAge = resultSetMinion.getInt(2);

                System.out.printf(MINION_FORMAT, index, minionName, minionAge);
                System.out.println();
            }
        }

        sqlConnection.close();
    }
}
