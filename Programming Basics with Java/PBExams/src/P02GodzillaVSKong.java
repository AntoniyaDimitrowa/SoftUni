import java.util.Scanner;

public class P02GodzillaVSKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int extrasCount = Integer.parseInt(scanner.nextLine());
        double clothesForOneExtraPrice = Double.parseDouble(scanner.nextLine());
        double decor = 0.10 * budget;
        double clothesPrice = extrasCount * clothesForOneExtraPrice;
        if(extrasCount > 150) {
            clothesPrice = clothesPrice - (clothesPrice * 0.10);
        }
        double price = decor + clothesPrice;

        if(price > budget) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", Math.abs(price - budget));
        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", Math.abs(price - budget));
        }
    }
}
