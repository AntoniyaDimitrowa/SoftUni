package P04_HotelReservation;

import java.util.Scanner;

public class Main {
    enum Season {
        Autumn(1), Spring(2), Winter(3), Summer(4);

        private int value;

        Season(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    enum DiscountType {
        VIP(20), SecondVisit(10), None(0);

        private int value;

        DiscountType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        double totalPrice = PriceCalculator.calculate(input);
        System.out.printf("%.2f", totalPrice);

    }
}
