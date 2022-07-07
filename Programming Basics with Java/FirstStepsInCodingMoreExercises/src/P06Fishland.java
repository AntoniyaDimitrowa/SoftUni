import java.util.Scanner;

public class P06Fishland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double mackerelPricePerKilogram = Double.parseDouble(scanner.nextLine());
        double spratPricePerKilogram = Double.parseDouble(scanner.nextLine());
        double kilosOfBonito = Double.parseDouble(scanner.nextLine());
        double kilosOfScad = Double.parseDouble(scanner.nextLine());
        double kilosOfClams = Double.parseDouble(scanner.nextLine());

        double bonitoPricePerKilogram = mackerelPricePerKilogram + (0.6 * mackerelPricePerKilogram);
        double scadPricePerKilogram = spratPricePerKilogram + (0.8 * spratPricePerKilogram);
        double clamsPricePerKilogram = 7.50;

        double totalSum = (kilosOfBonito * bonitoPricePerKilogram) + (kilosOfScad * scadPricePerKilogram) + (kilosOfClams * clamsPricePerKilogram);

        System.out.printf("%.2f", totalSum);
    }
}
