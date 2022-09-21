import java.util.Scanner;

public class P07_VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command1 = scanner.nextLine();
        double insertedMoney = 0.0;
        while(!command1.equals("Start")) {
            double currMoney = Double.parseDouble(command1);
            if(currMoney == 0.1 || currMoney == 0.2 || currMoney == 0.5 || currMoney == 1.0 || currMoney == 2.0){
                insertedMoney += currMoney;
            } else {
                System.out.printf("Cannot accept %.2f%n", currMoney);
            }
            command1 = scanner.nextLine();
        }
        String command2 = scanner.nextLine();
        while(!command2.equals("End")) {
            double price = 0.0;
            switch (command2) {
                case "Nuts":
                    price = 2.0;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.0;
                    break;
                default:
                    System.out.println("Invalid product");
            }
            if(price <= insertedMoney && price != 0) {
                System.out.printf("Purchased %s%n", command2);
                insertedMoney -= price;
            } else if(price != 0){
                System.out.println("Sorry, not enough money");
            }
            command2 = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", insertedMoney);
    }
}
