import java.util.Scanner;

public class P04FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishersCount = Integer.parseInt(scanner.nextLine());

        int priceWithoutDiscount = 0;
        double priceWithDiscount = 0.0;

        if(season.equals("Spring")) {
            priceWithoutDiscount = 3000;
        } else if(season.equals("Summer") || season.equals("Autumn")) {
            priceWithoutDiscount = 4200;
        } else if(season.equals("Winter")) {
            priceWithoutDiscount = 2600;
        }

        if(fishersCount <= 6) {
            priceWithDiscount = priceWithoutDiscount - priceWithoutDiscount * 0.10;
        } else if(fishersCount>=7 && fishersCount <= 11) {
            priceWithDiscount = priceWithoutDiscount - priceWithoutDiscount * 0.15;
        } else {
            priceWithDiscount = priceWithoutDiscount - priceWithoutDiscount * 0.25;
        }

        if(fishersCount % 2 == 0 && !(season.equals("Autumn"))) {
            priceWithDiscount = priceWithDiscount - priceWithDiscount * 0.05;
        }

        if(budget >= priceWithDiscount) {
            System.out.printf("Yes! You have %.2f leva left.", budget - priceWithDiscount);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", priceWithDiscount - budget);
        }
    }
}
