import java.util.Scanner;

public class P03Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chrysanthemums = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int tulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        char isHoliday = scanner.next().charAt(0);

        double price = 0.0;
        switch (season) {
            case "Spring":
            case "Summer":
                price = chrysanthemums * 2.00 + roses * 4.10 + tulips * 2.50;;
                break;
            case "Autumn":
            case "Winter":
                price = chrysanthemums * 3.75 + roses * 4.50 + tulips * 4.15;
                break;
        }

        if(isHoliday == 'Y') {
            price = price + price * 0.15;
        }

        if(tulips > 7 && season.equals("Spring")) {
            price = price - price * 0.05;
        }
        if(roses > 9 && season.equals("Winter")) {
            price = price - price * 0.10;
        }
        if((chrysanthemums + roses + tulips) > 20) {
            price = price - price * 0.20;
        }

        price = price + 2;
        System.out.printf("%.2f", price);
    }
}
