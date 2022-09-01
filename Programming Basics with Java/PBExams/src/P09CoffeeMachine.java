import java.util.Scanner;

public class P09CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String drink = scanner.nextLine();
        String sugar = scanner.nextLine();
        int cups = Integer.parseInt(scanner.nextLine());
        double price = 0.0;

        if (sugar.equals("Without")) {
            switch (drink) {
                case "Espresso":
                    price = price + 0.90 * cups;
                    price = price * 0.65;
                    if (price >= 5) {
                        price = price * 0.75;
                    }
                    break;
                case "Cappuccino":
                    price = price + 1.00 * cups;
                    price *= 0.65;
                    break;
                case "Tea":
                    price = price + 0.50 * cups;
                    price *= 0.65;
                    break;
            }
        } else if ("Normal".equals(sugar)) {
            switch (drink) {
                case "Espresso":
                    price = price + 1.00 * cups;
                    if (price >= 5) {
                        price = price * 0.75;
                    }
                    break;
                case "Cappuccino":
                    price = price + 1.20 * cups;
                    break;
                case "Tea":
                    price = price + 0.60 * cups;
                    break;
            }
        } else if ("Extra".equals(sugar)) {
            switch (drink) {
                case "Espresso":
                    price = price + 1.20 * cups;
                    if (price >= 5) {
                        price = price * 0.75;
                    }
                    break;
                case "Cappuccino":
                    price = price + 1.60 * cups;
                    break;
                case "Tea":
                    price = price + 0.70 * cups;
                    break;
            }
        }

        if (price > 15.0) {
            price = price * 0.8;
        }

        System.out.printf("You bought %d cups of %s for %.2f lv.", cups, drink, price);

    }
}
