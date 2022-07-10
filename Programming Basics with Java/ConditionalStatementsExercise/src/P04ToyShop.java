import java.util.Scanner;

public class P04ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double tripPrise = Double.parseDouble(scanner.nextLine());
        int puzzelsCount = Integer.parseInt(scanner.nextLine());
        int talkingDollsCount = Integer.parseInt(scanner.nextLine());
        int teddyBearsCount = Integer.parseInt(scanner.nextLine());
        int minionsCount = Integer.parseInt(scanner.nextLine());
        int trucksCount = Integer.parseInt(scanner.nextLine());

        int totalToysCount = puzzelsCount + talkingDollsCount + teddyBearsCount + minionsCount + trucksCount;
        double profit = (puzzelsCount * 2.60) + (talkingDollsCount * 3) + (teddyBearsCount * 4.10) + (minionsCount * 8.20) + (trucksCount * 2);

        if(totalToysCount >= 50) {
            profit = profit - (0.25 * profit);
        }

        double moneyForRent = profit * 0.10;
        double totalProfit = profit - moneyForRent;

        if(totalProfit >= tripPrise) {
            System.out.printf("Yes! %.2f lv left.", totalProfit - tripPrise);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", tripPrise - totalProfit);
        }
    }
}
