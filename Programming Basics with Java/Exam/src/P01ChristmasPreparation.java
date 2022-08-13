import java.util.Scanner;

public class P01ChristmasPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rollsOfWrappingPaper = Integer.parseInt(scanner.nextLine());
        int fabricRolls = Integer.parseInt(scanner.nextLine());
        double litersOfGlue = Double.parseDouble(scanner.nextLine());
        int discountPercent = Integer.parseInt(scanner.nextLine());

        double rollsOfWrappingPaperPrice = rollsOfWrappingPaper * 5.80;
        double fabricRollsPrice = fabricRolls * 7.20;
        double litersOfGluePrice = litersOfGlue * 1.20;

        double priceWithoutDiscount = rollsOfWrappingPaperPrice + fabricRollsPrice + litersOfGluePrice;
        double priceWithDiscount = priceWithoutDiscount - (priceWithoutDiscount * (discountPercent /100.0));
        System.out.printf("%.3f", priceWithDiscount);

    }
}
