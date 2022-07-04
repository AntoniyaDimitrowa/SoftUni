import java.util.Scanner;

public class P07FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chickenMenusCount = Integer.parseInt(scanner.nextLine());
        int fishMenusCount = Integer.parseInt(scanner.nextLine());
        int vegetarianMenusCount = Integer.parseInt(scanner.nextLine());

        double totalPriceMenus = chickenMenusCount * 10.35 + fishMenusCount * 12.40 + vegetarianMenusCount * 8.15;
        double desertPrice = 0.2 * totalPriceMenus;
        double finalePrice = totalPriceMenus + desertPrice + 2.50;
        System.out.println(finalePrice);
    }
}
