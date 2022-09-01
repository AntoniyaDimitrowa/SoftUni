import java.util.Scanner;

public class P08FamilyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double oneNightPrice = Double.parseDouble(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());

        if(nights > 7) {
            oneNightPrice = oneNightPrice * 0.95;
        }
        double price = (oneNightPrice * nights) + (budget * (percent / 100.0));

        if(price > budget) {
            System.out.printf("%.2f leva needed.", price - budget);
        } else {
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", budget - price);
        }
    }
}
