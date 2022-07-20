import java.util.Scanner;

public class P09SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine();
        String grade = scanner.nextLine();
        double price = 0.0;
        int nights = days - 1;

        if(roomType.equals("room for one person")) {
            price = nights * 18.00;
        } else if(roomType.equals("apartment")) {
            price = nights * 25.00;
            if(nights<10)
            {
                price = price - price * 0.30;
            }
            else if(nights>15)
            {
                price = price - price * 0.50;
            }
            else
            {
                price = price - price * 0.35;
            }
        } else if(roomType.equals("president apartment")) {
            price = nights * 35.00;
            if(nights<10)
            {
                price = price - price * 0.10;
            }
            else if(nights>15)
            {
                price = price - price * 0.20;
            }
            else
            {
                price = price - price * 0.15;
            }
        }

        if(grade.equals("positive")) {
            price = price + price * 0.25;
        } else {
            price = price - price * 0.10;
        }

        System.out.printf("%.2f", price);
    }
}
