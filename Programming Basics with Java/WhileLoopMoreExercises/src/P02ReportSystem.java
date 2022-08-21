import java.util.Scanner;

public class P02ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int expectedAmountOfMoney = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int collectedMoney = 0;
        int counter = 0;
        int cardPayments = 0;
        int cashPayments = 0;
        int moneyFromCardPayments = 0;
        int moneyFromCashPayments = 0;

        while(!command.equals("End")) {
            counter++;
            int currMoney = Integer.parseInt(command);
            if(counter % 2 != 0) {
                if(currMoney > 100) {
                    System.out.println("Error in transaction!");
                } else {
                    System.out.println("Product sold!");
                    collectedMoney += currMoney;
                    moneyFromCashPayments += currMoney;
                    cashPayments++;
                }
            } else {
                if(currMoney < 10) {
                    System.out.println("Error in transaction!");
                } else {
                    System.out.println("Product sold!");
                    collectedMoney += currMoney;
                    moneyFromCardPayments += currMoney;
                    cardPayments++;
                }
            }
            if(collectedMoney >= expectedAmountOfMoney) {
                System.out.printf("Average CS: %.2f%n", moneyFromCashPayments * 1.0 / cashPayments);
                System.out.printf("Average CC: %.2f", moneyFromCardPayments * 1.0 / cardPayments);
                break;
            }
            command = scanner.nextLine();
        }
        if(collectedMoney < expectedAmountOfMoney) {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}
