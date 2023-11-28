import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetVillainsNames {
    private static final String GET_VILLAINS_NAMES =
            "SELECT CONCAT_WS(' ', v.`name`, COUNT(DISTINCT mv.`minion_id`)) AS 'Output' " +
            "FROM `villains` AS v " +
            "JOIN `minions_villains` AS mv ON v.`id` = mv.`villain_id` " +
            "GROUP BY mv.`villain_id` " +
            "HAVING COUNT(DISTINCT mv.`minion_id`) > 15 " +
            "ORDER BY COUNT(DISTINCT mv.`minion_id`) DESC;";

    public static void main(String[] args) throws SQLException {
        final Connection sqlConnection = Utils.getSQLConnection();

        final PreparedStatement ps = sqlConnection.prepareStatement(GET_VILLAINS_NAMES);

        final ResultSet resultSet = ps.executeQuery();

        while(resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }

        sqlConnection.close();
    }
}
