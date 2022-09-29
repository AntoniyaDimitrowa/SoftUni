import java.util.Scanner;

public class P09_SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());
        int totalAmount = 0;
        int daysCounter = 0;

        while(startingYield > 0) {
            if(startingYield < 100) {
                if(totalAmount < 26) {
                    break;
                }
                totalAmount -= 26;
                break;
            }
            daysCounter++;
            totalAmount += (startingYield - 26);
            startingYield -= 10;
        }

        System.out.println(daysCounter);
        System.out.println(totalAmount);
    }
}
