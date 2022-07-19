import java.util.Scanner;

public class P05Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String destination = "";
        String typeJourney = "";
        double price = 0;
        if(budget<=100)
        {
            destination = "Bulgaria";
            if(season.equals("summer"))
            {
                typeJourney = "Camp";
                price = budget * 0.3;
            }
            if (season.equals("winter"))
            {
                typeJourney = "Hotel";
                price = budget * 0.7;
            }
        }
        else if (budget <= 1000)
        {
            destination = "Balkans";
            if (season.equals("summer"))
            {
                typeJourney = "Camp";
                price = budget * 0.4;
            }
            if (season.equals("winter"))
            {
                typeJourney = "Hotel";
                price = budget * 0.8;
            }
        }
        else
        {
            destination = "Europe";
            typeJourney = "Hotel";
            price = budget * 0.9;
        }
        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", typeJourney, price);
    }
}
