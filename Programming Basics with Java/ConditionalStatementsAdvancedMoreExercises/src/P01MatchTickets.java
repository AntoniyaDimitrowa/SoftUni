import java.util.Scanner;

public class P01MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int peopleCount = Integer.parseInt(scanner.nextLine());

        double moneyForTransport = 0.0;
        if(peopleCount < 5) {
            moneyForTransport = budget * 0.75;
        } else if(peopleCount < 10) {
            moneyForTransport = budget * 0.60;
        } else if(peopleCount < 25) {
            moneyForTransport = budget * 0.50;
        } else if(peopleCount < 50) {
            moneyForTransport = budget * 0.40;
        } else {
            moneyForTransport = budget * 0.25;
        }

        double balance = budget - moneyForTransport;

        double moneyForTickets = 0.0;
        if(category.equals("VIP")) {
            moneyForTickets = 499.99 * peopleCount;
        } else if(category.equals("Normal")) {
            moneyForTickets = 249.99 * peopleCount;
        }

        if(balance >= moneyForTickets) {
            System.out.printf("Yes! You have %.2f leva left.", balance - moneyForTickets);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", moneyForTickets - balance);
        }
    }
}
