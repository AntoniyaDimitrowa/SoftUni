import java.util.Scanner;

public class P04VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pricePerKilogramVegetables = Double.parseDouble(scanner.nextLine());
        double pricePerKilogramFruits = Double.parseDouble(scanner.nextLine());
        int kilogramsVegetables = Integer.parseInt(scanner.nextLine());
        int kilogramsFruits = Integer.parseInt(scanner.nextLine());

        double incomeBNG = (pricePerKilogramVegetables * kilogramsVegetables) + (pricePerKilogramFruits * kilogramsFruits);
        double incomeEUR = incomeBNG / 1.94;
        System.out.printf("%.2f",incomeEUR);
    }
}
