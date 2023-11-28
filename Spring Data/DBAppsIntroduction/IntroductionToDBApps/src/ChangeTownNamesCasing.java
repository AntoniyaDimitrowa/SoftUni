import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ChangeTownNamesCasing {
    private static final String QUERY_FOR_UPDATING_TOWNS_NAMES_CASING_BY_COUNTRY = "UPDATE `towns` SET `name` = UPPER(`name`) WHERE `country` = ?;";
    private static final String QUERY_FOR_FINDING_COUNT_OF_TOWNS_BY_COUNTRY = "SELECT COUNT(`id`) FROM `towns` WHERE `country` = ?;";
    private static final String QUERY_FOR_FINDING_NAMES_OF_TOWNS_BY_COUNTRY = "SELECT `name` FROM `towns` WHERE `country` = ?;";

    private static final String LABEL_FOR_COUNT_OF_AFFECTED_TOWNS = "%d town names were affected.";
    private static final String LABEL_WHEN_NO_TOWNS_WERE_AFFECTED = "No town names were affected.";

    public static void main(String[] args) throws SQLException {
        final Connection sqlConnection = Utils.getSQLConnection();

        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();

        PreparedStatement statementForTownsCountInCountry = sqlConnection.prepareStatement(QUERY_FOR_FINDING_COUNT_OF_TOWNS_BY_COUNTRY);
        statementForTownsCountInCountry.setString(1, country);
        ResultSet resultSetCountOfTowns = statementForTownsCountInCountry.executeQuery();
        resultSetCountOfTowns.next();
        int affectedTowns = resultSetCountOfTowns.getInt(1);

        if(affectedTowns < 1) {
            System.out.println(LABEL_WHEN_NO_TOWNS_WERE_AFFECTED);
        } else {
            PreparedStatement statementForUpdatingTownsNamesCasing = sqlConnection.prepareStatement(QUERY_FOR_UPDATING_TOWNS_NAMES_CASING_BY_COUNTRY);
            statementForUpdatingTownsNamesCasing.setString(1, country);
            statementForUpdatingTownsNamesCasing.executeUpdate();

            print(sqlConnection, country, affectedTowns);
        }

        sqlConnection.close();
    }

    private static void print(Connection sqlConnection, String country, int affectedTowns) throws SQLException {
        System.out.printf(LABEL_FOR_COUNT_OF_AFFECTED_TOWNS, affectedTowns);
        System.out.println();

        PreparedStatement statementForTownsNamesInCountry = sqlConnection.prepareStatement(QUERY_FOR_FINDING_NAMES_OF_TOWNS_BY_COUNTRY);
        statementForTownsNamesInCountry.setString(1, country);
        ResultSet resultSetNamesOfTowns = statementForTownsNamesInCountry.executeQuery();

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(resultSetNamesOfTowns.next()) {
            sb.append(resultSetNamesOfTowns.getString(1)).append(", ");
        }
        String result = sb.substring(0,sb.length() - 2);
        result += "]";
        System.out.println(result);
    }
}
