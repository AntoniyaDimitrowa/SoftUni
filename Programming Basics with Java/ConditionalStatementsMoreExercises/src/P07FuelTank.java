import java.util.Scanner;

public class P07FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input fuel type:");
        String fuelType = scanner.nextLine();
        System.out.println("Input how much fuel you currently have:");
        double currLitersFuel = Double.parseDouble(scanner.nextLine());
        System.out.println("Input fuel tank volume:");
        double fuelTankVolume = Double.parseDouble(scanner.nextLine());
        System.out.println("Input \"Yes\", if you have club card or \"No\", if you don't:");
        String clubCard = scanner.nextLine();
        double price = 0;
        boolean fuelIsValid = true;

        double neededLitersFuel = fuelTankVolume - currLitersFuel;

        if (fuelType.equals("Diesel")) {
            System.out.println("Input how much does it cost for one liter diesel:");
            double dieselPricePerLiter = Double.parseDouble(scanner.nextLine());
            price = neededLitersFuel * dieselPricePerLiter;
            if (clubCard.equals("Yes")) {
                price = price - neededLitersFuel * 0.12;
            }
        } else if (fuelType.equals("Gasoline")) {
            System.out.println("Input how much does it cost for one liter gasoline:");
            double gasolinePricePerLiter = Double.parseDouble(scanner.nextLine());
            price = neededLitersFuel * gasolinePricePerLiter;
            if (clubCard.equals("Yes")) {
                price = price - neededLitersFuel * 0.18;
            }
        } else if (fuelType.equals("Gas")) {
            System.out.println("Input how much does it cost for one liter gas:");
            double gasPricePerLiter = Double.parseDouble(scanner.nextLine());
            price = neededLitersFuel * gasPricePerLiter;
            if (clubCard.equals("Yes")) {
                price = price - neededLitersFuel * 0.08;
            }
        } else {
            System.out.println("Invalid fuel!");
            fuelIsValid = false;
        }

        if (neededLitersFuel >= 20 && neededLitersFuel <= 25) {
            price = price - (price * 0.08);
        } else if (neededLitersFuel > -25) {
            price = price - (price * 0.10);
        }

        if (fuelIsValid) {
            System.out.printf("%.2f lv.", price);
        }
    }
}
