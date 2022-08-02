import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double neededMoney = Double.parseDouble(scanner.nextLine());
        double ownedMoney = Double.parseDouble(scanner.nextLine());
        int spendingCounter = 0;
        int daysCounter = 0;
        while (true) {
            if (spendingCounter >= 5) {
                System.out.println("You can't save the money.");
                System.out.printf("%d", daysCounter);
                break;
            }
            if (ownedMoney >= neededMoney) {
                System.out.printf("You saved the money for %d days.", daysCounter);
                break;
            }
            String command = scanner.nextLine();
            double currMoney = Double.parseDouble(scanner.nextLine());
            if (command.equals("spend")) {
                spendingCounter++;
                if (currMoney < ownedMoney) {
                    ownedMoney = ownedMoney - currMoney;
                }
                else {
                    ownedMoney = 0;
                }
            } else if (command.equals("save")) {
                ownedMoney += currMoney;
                spendingCounter = 0;
            }
            daysCounter++;
        }
    }
}
