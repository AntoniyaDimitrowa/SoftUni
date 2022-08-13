import java.util.Scanner;

public class P02MaidenParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double partyPrice = Double.parseDouble(scanner.nextLine());
        int loveMessagesCount = Integer.parseInt(scanner.nextLine());
        int waxRosesCount = Integer.parseInt(scanner.nextLine());
        int keyHoldersCount = Integer.parseInt(scanner.nextLine());
        int cartoonsCount = Integer.parseInt(scanner.nextLine());
        int luckySurprisesCount = Integer.parseInt(scanner.nextLine());
        int totalProducts = loveMessagesCount + waxRosesCount + keyHoldersCount + cartoonsCount + luckySurprisesCount;

        double profit = (loveMessagesCount * 0.60) + (waxRosesCount * 7.20) + (keyHoldersCount * 3.60) + (cartoonsCount * 18.20) + (luckySurprisesCount * 22);

        if(totalProducts >= 25) {
            profit = profit - (profit * 0.35);
        }

        double finaleProfit = profit - (profit * 0.10);

        if(finaleProfit >= partyPrice) {
            System.out.printf("Yes! %.2f lv left.", Math.abs(finaleProfit - partyPrice));
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", Math.abs(finaleProfit - partyPrice));
        }
    }
}
