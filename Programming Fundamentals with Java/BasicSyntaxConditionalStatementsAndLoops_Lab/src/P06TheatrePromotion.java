import java.util.Scanner;

public class P06TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dayType = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        int price = 0;
        if(age >= 0 && age <= 18) {
            switch (dayType) {
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 5;
                    break;
            }
            System.out.println(price + "$");
        } else if(age > 18 && age <= 64) {
            switch (dayType) {
                case "Weekday":
                    price = 18;
                    break;
                case "Weekend":
                    price = 20;
                    break;
                case "Holiday":
                    price = 12;
                    break;
            }
            System.out.println(price + "$");
        } else if(age > 64 && age <= 122) {
            switch (dayType) {
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 10;
                    break;
            }
            System.out.println(price + "$");
        } else {
            System.out.println("Error!");
        }
    }
}
