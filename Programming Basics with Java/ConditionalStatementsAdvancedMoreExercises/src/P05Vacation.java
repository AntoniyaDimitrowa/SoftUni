import java.util.Scanner;

public class P05Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String[] locations = {"Alaska", "Morocco"};
        String[] placesForStaying = {"Hotel", "Hut", "Camp"};
        int locationIndex = 0;
        int placeForStayingIndex = 0;
        double price = 0.0;

        if(budget <= 1000) {
            placeForStayingIndex = 2;
            switch (season) {
                case "Summer":
                    price = budget * 0.65;
                    locationIndex = 0;
                    break;
                case "Winter":
                    price = budget * 0.45;
                    locationIndex = 1;
                    break;
            }
        } else if(budget <= 3000) {
            placeForStayingIndex = 1;
            switch (season) {
                case "Summer":
                    price = budget * 0.80;
                    locationIndex = 0;
                    break;
                case "Winter":
                    price = budget * 0.60;
                    locationIndex = 1;
                    break;
            }
        } else {
            placeForStayingIndex = 0;
            price = budget * 0.90;
            switch (season) {
                case "Summer":
                    locationIndex = 0;
                    break;
                case "Winter":
                    locationIndex = 1;
                    break;
            }
        }
        System.out.printf("%s - %s - %.2f", locations[locationIndex], placesForStaying[placeForStayingIndex], price);
    }
}
