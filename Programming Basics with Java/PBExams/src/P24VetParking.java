import java.util.Scanner;

public class P24VetParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int daysCount = Integer.parseInt(scanner.nextLine());
        int hoursCount = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0.0;

        for(int day = 1; day <= daysCount; day++) {
            double priceForTheDay = 0.0;
            for(int hour = 1; hour <= hoursCount; hour++) {
                if(day % 2 == 0 && hour %2 != 0) {
                    priceForTheDay += 2.50;
                } else if(day % 2 != 0 && hour %2 == 0) {
                    priceForTheDay += 1.25;
                } else {
                    priceForTheDay += 1;
                }
            }
            totalPrice += priceForTheDay;
            System.out.printf("Day: %d - %.2f leva%n", day, priceForTheDay);
        }
        System.out.printf("Total: %.2f leva", totalPrice);
    }
}
