import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveVillain {
    private static final String QUERY_FOR_FINDING_VILLAIN_NAME_BY_ID = "SELECT `name` FROM `villains` WHERE `id` = ?";
    private static final String QUERY_FOR_FINDING_COUNT_OF_MINIONS_WORKING_FOR_THE_VILLAIN = "SELECT COUNT(*) FROM `minions_villains` WHERE `villain_id` = ?";
    private static final String QUERY_FOR_DELETING_MINIONS_BY_VILLAIN_ID = "DELETE FROM `minions_villains` WHERE `villain_id` = ?";
    private static final String QUERY_FOR_DELETING_VILLAIN = "DELETE FROM `villains` WHERE `villain_id` = ?";

    private static final String LABEL_FOR_NOT_EXISTING_VILLAIN = "No such villain was found";
    private static final String LABEL_FOR_DELETED_VILLAIN = "%s was deleted";
    private static final String LABEL_FOR_RELEASED_MINIONS = "%d minions released";

    public static void main(String[] args) throws SQLException {
        final Connection sqlConnection = Utils.getSQLConnection();

        Scanner scanner = new Scanner(System.in);
        int villainId = Integer.parseInt(scanner.nextLine());

        PreparedStatement statementForCheckingIfVillainExists = sqlConnection.prepareStatement(QUERY_FOR_FINDING_VILLAIN_NAME_BY_ID);
        statementForCheckingIfVillainExists.setInt(1, villainId);
        ResultSet resultSet = statementForCheckingIfVillainExists.executeQuery();

        if(!resultSet.next()) {
            System.out.println(LABEL_FOR_NOT_EXISTING_VILLAIN);
            sqlConnection.close();
            return;
        }

        final String villainName = resultSet.getString(1);

        int releasedMinionsCount = getReleasedMinionsCount(sqlConnection, villainId);

        sqlConnection.setAutoCommit(false);
        try ( PreparedStatement statementForReleasingMinions = sqlConnection.prepareStatement(QUERY_FOR_DELETING_MINIONS_BY_VILLAIN_ID);
        PreparedStatement statementForDeletingVillain = sqlConnection.prepareStatement(QUERY_FOR_DELETING_VILLAIN);) {
            statementForReleasingMinions.setInt(1, villainId);
            statementForReleasingMinions.executeUpdate();

            statementForReleasingMinions.setInt(1, villainId);
            statementForReleasingMinions.executeUpdate();

            sqlConnection.commit();

            getPrint(villainName, releasedMinionsCount);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

            sqlConnection.rollback();
        }
    }

    private static void getPrint(String villainName, int releasedMinionsCount) {
        System.out.printf(LABEL_FOR_DELETED_VILLAIN, villainName);
        System.out.println();
        System.out.printf(LABEL_FOR_RELEASED_MINIONS, releasedMinionsCount);
    }

    private static int getReleasedMinionsCount(Connection sqlConnection, int villainId) throws SQLException {
        PreparedStatement statementForFindingReleasedMinionsCount = sqlConnection.prepareStatement(QUERY_FOR_FINDING_COUNT_OF_MINIONS_WORKING_FOR_THE_VILLAIN);
        statementForFindingReleasedMinionsCount.setInt(1, villainId);
        ResultSet resultSet = statementForFindingReleasedMinionsCount.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }
}
