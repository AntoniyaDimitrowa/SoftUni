import java.util.Scanner;

public class P11Club {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double wantedProfit = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();
        double actualProfit = 0.0;

        while (!command.equals("Party!")) {
            String cocktailName = command;
            int cocktailCount = Integer.parseInt(scanner.nextLine());
            int cocktailsPrice = cocktailName.length() * cocktailCount;
            double finalePrice = cocktailsPrice;
            if(finalePrice % 2 != 0) {
                finalePrice *= 0.75;
            }
            actualProfit = actualProfit + finalePrice;
            if(actualProfit >= wantedProfit) {
                System.out.println("Target acquired.");
                System.out.printf("Club income - %.2f leva.", actualProfit);
                break;
            }
            command = scanner.nextLine();
        }
        if(actualProfit < wantedProfit) {
            System.out.printf("We need %.2f leva more.%n", wantedProfit - actualProfit);
            System.out.printf("Club income - %.2f leva.", actualProfit);
        }
    }
}
