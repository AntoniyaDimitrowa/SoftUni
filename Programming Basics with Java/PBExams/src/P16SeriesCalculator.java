import java.util.Scanner;

public class P16SeriesCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int seasonsCount = Integer.parseInt(scanner.nextLine());
        int episodesCount = Integer.parseInt(scanner.nextLine());
        double episodeDuration = Double.parseDouble(scanner.nextLine());

        double result = seasonsCount * episodesCount * (episodeDuration + 0.20 * episodeDuration);
        result = result + seasonsCount * 10;
        System.out.printf("Total time needed to watch the %s series is %.0f minutes.", name, Math.floor(result));
    }
}
