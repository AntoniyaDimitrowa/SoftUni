import java.util.Scanner;

public class P07PoolDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        double entranceTax = Double.parseDouble(scanner.nextLine());
        double loungePrice = Double.parseDouble(scanner.nextLine());
        double umbrellaPrice = Double.parseDouble(scanner.nextLine());

        double moneyForEntrance = people * entranceTax;
        double moneyForUmbrellas = Math.ceil(people / 2.0) * umbrellaPrice;
        double moneyForLounges = Math.ceil(people * 0.75) * loungePrice;

        double totalPrice = moneyForEntrance + moneyForLounges + moneyForUmbrellas;
        System.out.printf("%.2f lv.", totalPrice);
    }
}
