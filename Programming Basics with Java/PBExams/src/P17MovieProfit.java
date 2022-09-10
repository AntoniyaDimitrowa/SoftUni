import java.util.Scanner;

public class P17MovieProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int daysCount = Integer.parseInt(scanner.nextLine());
        int ticketsCount = Integer.parseInt(scanner.nextLine());
        double ticketPrice = Double.parseDouble(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());

        double ticketsPricePerDay = ticketsCount * ticketPrice;

        double totalPrice = ticketsPricePerDay * daysCount;
        double moneyForCinema = totalPrice * percent / 100.0;
        double studioIncome = totalPrice - moneyForCinema;

        System.out.printf("The profit from the movie %s is %.2f lv.", name, studioIncome);
    }
}
