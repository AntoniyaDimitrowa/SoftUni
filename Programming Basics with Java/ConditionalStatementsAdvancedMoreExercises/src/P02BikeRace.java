import java.util.Scanner;

public class P02BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int juniorsCount = Integer.parseInt(scanner.nextLine());
        int seniorsCount = Integer.parseInt(scanner.nextLine());
        String trackType = scanner.nextLine();

        double profit = 0.0;
        switch (trackType) {
            case "trail":
                profit = juniorsCount * 5.50 + seniorsCount * 7;
                break;
            case "cross-country":
                if((juniorsCount + seniorsCount) > 49) {
                    profit = juniorsCount * (8 - 8 * 0.25) + seniorsCount * (9.50 - 9.50 * 0.25);
                } else {
                    profit = juniorsCount * 8 + seniorsCount * 9.50;
                }
                break;
            case "downhill":
                profit = juniorsCount * 12.25 + seniorsCount * 13.75;
                break;
            case "road":
                profit = juniorsCount * 20 + seniorsCount * 21.50;
                break;
        }

        double finaleProfit = profit - profit * 0.05;
        System.out.printf("%.2f",finaleProfit);
    }
}
