import java.util.Locale;
import java.util.Scanner;

public class P05Everest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int daysCounter = 1;
        int metersCounter = 5364;
        boolean isSucceeded = false;

        while (!command.equals("END"))
        {
            String isSpendingTheNight = command.toLowerCase();
            if (isSpendingTheNight.equals("yes"))
            {
                daysCounter++;
            }
            int climbedMeters = Integer.parseInt(scanner.nextLine());
            if (daysCounter > 5)
            {
                isSucceeded = false;
                break;
            }
            metersCounter += climbedMeters;

            if (metersCounter >= 8848)
            {
                isSucceeded = true;
                break;
            }

            command = scanner.nextLine();
        }

        if (isSucceeded)
        {
            System.out.printf("Goal reached for %d days!", daysCounter);
        }
        else
        {
            System.out.println("Failed!");
            System.out.printf("%d", metersCounter);
        }
    }
}
