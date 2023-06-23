import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddMinion {
    private static final String QUERY_FOR_ADDING_TOWN = "INSERT INTO `towns`(`name`) VALUES(?)";
    private static final String QUERY_FOR_ADDING_VILLAIN = "INSERT INTO `villains`(`name`, `evilness_factor`) VALUES(?, 'evil')";
    private static final String QUERY_FOR_ADDING_MINION_IN_TABLE_MINIONS = "INSERT INTO `minions`(`name`, `age`, `town_id`) VALUES(?, ?, ?)";
    private static final String QUERY_FOR_ADDING_MINION_IN_TABLE_MINIONS_VILLAINS = "INSERT INTO `minions_villains`(`minion_id`, `villain_id`) VALUES(?, ?)";

    private static final String QUERY_FOR_FINDING_TOWN_ID_BY_NAME = "SELECT `id` FROM `towns` WHERE `name` = ?";
    private static final String QUERY_FOR_FINDING_VILLAIN_ID_BY_NAME = "SELECT `id` FROM `villains` WHERE `name` = ?";
    private static final String QUERY_FOR_FINDING_MINION_ID_BY_NAME = "SELECT `id` FROM `minions` WHERE `name` = ?";

    private static final String LABEL_FOR_SUCCESSFULLY_ADDING_MINION = "Successfully added %s to be minion of %s.";
    private static final String LABEL_FOR_ADDING_NEW_TOWN = "Town %s was added to the database.";
    private static final String LABEL_FOR_ADDING_NEW_VILLAIN = "Villain %s was added to the database.";

    public static void main(String[] args) throws SQLException {
        final Connection sqlConnection = Utils.getSQLConnection();

        Scanner scanner = new Scanner(System.in);
        String[] minionInfo = scanner.nextLine().split(" ");
        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String townName = minionInfo[3];

        String[] villainInfo = scanner.nextLine().split(" ");
        String villainName = villainInfo[1];

        int townId = findTownIdAndAddItIfNotExists(sqlConnection, townName);

        PreparedStatement statementForAddingMinionInTableMinions = sqlConnection.prepareStatement(QUERY_FOR_ADDING_MINION_IN_TABLE_MINIONS);
        statementForAddingMinionInTableMinions.setString(1, minionName);
        statementForAddingMinionInTableMinions.setInt(2, minionAge);
        statementForAddingMinionInTableMinions.setInt(3, townId);
        statementForAddingMinionInTableMinions.executeUpdate();

        int minionId = findMinionId(sqlConnection, minionName);
        int villainId = findVillainIdAndAddItIfNotExists(sqlConnection, villainName);

        PreparedStatement statementForAddingMinionInTableMinions_Villains = sqlConnection.prepareStatement(QUERY_FOR_ADDING_MINION_IN_TABLE_MINIONS_VILLAINS);
        statementForAddingMinionInTableMinions_Villains.setInt(1, minionId);
        statementForAddingMinionInTableMinions_Villains.setInt(2, villainId);
        statementForAddingMinionInTableMinions_Villains.executeUpdate();

        System.out.printf(LABEL_FOR_SUCCESSFULLY_ADDING_MINION, minionName, villainName);

        sqlConnection.close();
    }

    private static int findMinionId(Connection sqlConnection, String minionName) throws SQLException {
        PreparedStatement statementForFindingMinionId = sqlConnection.prepareStatement(QUERY_FOR_FINDING_MINION_ID_BY_NAME);
        statementForFindingMinionId.setString(1, minionName);
        ResultSet resultSet = statementForFindingMinionId.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    private static int findTownIdAndAddItIfNotExists(Connection sqlConnection, String townName) throws SQLException {
        PreparedStatement statementForFindingTownId = sqlConnection.prepareStatement(QUERY_FOR_FINDING_TOWN_ID_BY_NAME);
        statementForFindingTownId.setString(1, townName);
        ResultSet resultSet = statementForFindingTownId.executeQuery();
        if(!resultSet.next()) {
            PreparedStatement statementForAddingTown = sqlConnection.prepareStatement(QUERY_FOR_ADDING_TOWN);
            statementForAddingTown.setString(1, townName);
            statementForAddingTown.executeUpdate();
            System.out.printf(LABEL_FOR_ADDING_NEW_TOWN, townName);
            System.out.println();
        }
        resultSet = statementForFindingTownId.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    private static int findVillainIdAndAddItIfNotExists(Connection sqlConnection, String villainName) throws SQLException {
        PreparedStatement statementForFindingVillainId = sqlConnection.prepareStatement(QUERY_FOR_FINDING_VILLAIN_ID_BY_NAME);
        statementForFindingVillainId.setString(1, villainName);
        ResultSet resultSet = statementForFindingVillainId.executeQuery();
        if(!resultSet.next()) {
            PreparedStatement statementForAddingVillain = sqlConnection.prepareStatement(QUERY_FOR_ADDING_VILLAIN);
            statementForAddingVillain.setString(1, villainName);
            statementForAddingVillain.executeUpdate();
            System.out.printf(LABEL_FOR_ADDING_NEW_VILLAIN, villainName);
            System.out.println();
        }
        resultSet = statementForFindingVillainId.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }
}
