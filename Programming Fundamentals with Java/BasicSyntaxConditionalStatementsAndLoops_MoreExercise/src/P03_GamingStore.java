import java.util.Scanner;

public class P03_GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balanceInTheBeginning = Double.parseDouble(scanner.nextLine());
        double currBalance = balanceInTheBeginning;
        String command = scanner.nextLine();
        boolean noMoney = false;
        while(!command.equals("Game Time")) {
            String gameName = command;
            double price = 0.0;
            boolean isFound = true;
            switch (gameName) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                default:
                    System.out.println("Not Found");
                    isFound = false;
            }
            if(isFound) {
                if(price <= currBalance) {
                    System.out.printf("Bought %s%n", gameName);
                    currBalance -= price;
                } else {
                    System.out.println("Too Expensive");
                    command = scanner.nextLine();
                    continue;
                }
                if(currBalance == 0) {
                    System.out.println("Out of money!");
                    noMoney = true;
                    break;
                } else {
                    command = scanner.nextLine();
                }
            } else {
                command = scanner.nextLine();
            }
        }
        if(!noMoney) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", (balanceInTheBeginning - currBalance), currBalance);
        }
    }
}
