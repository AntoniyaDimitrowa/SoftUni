import java.util.Scanner;

public class P01_BurgerBus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCities = Integer.parseInt(scanner.nextLine());
        double totalProfit = 0;

        for (int i = 1; i <= numberOfCities; i++) {
            String cityName = scanner.nextLine();
            double earnedMoney = Double.parseDouble(scanner.nextLine());
            double ownersExpenses = Double.parseDouble(scanner.nextLine());


            if(i % 5 == 0) {
                earnedMoney = earnedMoney - earnedMoney * 0.10;
            } else {
                if (i % 3 == 0) {
                    ownersExpenses = ownersExpenses + ownersExpenses * 0.5;
                }
            }

            double currCityProfit = earnedMoney - ownersExpenses;
            totalProfit += currCityProfit;
            System.out.printf("In %s Burger Bus earned %.2f leva.%n", cityName, currCityProfit);
        }
        System.out.printf("Burger Bus total profit: %.2f leva.", totalProfit);
    }
}
