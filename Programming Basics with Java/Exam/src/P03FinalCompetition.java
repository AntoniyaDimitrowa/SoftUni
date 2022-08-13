import java.util.Scanner;

public class P03FinalCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dancersCount = Integer.parseInt(scanner.nextLine());
        double pointsCount = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = scanner.nextLine();

        double wonAmount = dancersCount * pointsCount;

        if(place.equals("Abroad")) {
            wonAmount = wonAmount + wonAmount * 0.50;
        }

        if(season.equals("summer")) {
            switch (place) {
                case "Bulgaria":
                    wonAmount = wonAmount - wonAmount * 0.05;
                    break;
                case "Abroad":
                    wonAmount = wonAmount - wonAmount * 0.10;
                    break;
            }
        } else if(season.equals("winter")) {
            switch (place) {
                case "Bulgaria":
                    wonAmount = wonAmount - wonAmount * 0.08;
                    break;
                case "Abroad":
                    wonAmount = wonAmount - wonAmount * 0.15;
                    break;
            }
        }

        double moneyForCharity = wonAmount * 0.75;
        double moneyPerDancer = (wonAmount * 0.25) / dancersCount;

        System.out.printf("Charity - %.2f%n", moneyForCharity);
        System.out.printf("Money per dancer - %.2f", moneyPerDancer);
    }
}
