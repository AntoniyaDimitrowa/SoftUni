import java.util.Scanner;

public class P06FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int magnoliasCount = Integer.parseInt(scanner.nextLine());
        int hyacinthsCount = Integer.parseInt(scanner.nextLine());
        int rosesCount = Integer.parseInt(scanner.nextLine());
        int cactiCount = Integer.parseInt(scanner.nextLine());
        double giftPrice = Double.parseDouble(scanner.nextLine());

        double profitWithoutTaxes = (magnoliasCount * 3.25) + (hyacinthsCount * 4) + (rosesCount * 3.50) + (cactiCount * 8);
        double finaleProfit = profitWithoutTaxes - (profitWithoutTaxes * 0.05);

        if(finaleProfit < giftPrice) {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(giftPrice - finaleProfit));
        } else {
            System.out.printf("She is left with %.0f leva.", Math.floor(finaleProfit - giftPrice));
        }
    }
}
