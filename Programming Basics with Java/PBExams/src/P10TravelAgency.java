import java.util.Scanner;

public class P10TravelAgency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String town = scanner.nextLine();
        String pack = scanner.nextLine();
        boolean hasVIP = scanner.nextLine().equals("yes");
        int days = Integer.parseInt(scanner.nextLine());
        boolean isValid = false;

        double price = 0.0;

        if (days > 7) {
            days--;
        }

        switch (town) {
            case "Bansko":
            case "Borovets":
                if (hasVIP) {
                    if (pack.equals("noEquipment")) {
                        price = 80 * 0.95;
                    } else if (pack.equals("withEquipment")) {
                        price = 100 * 0.9;
                    } else {
                        isValid = true;
                    }
                } else {
                    if (pack.equals("noEquipment")) {
                        price = 80;
                    } else if (pack.equals("withEquipment")) {
                        price = 100;
                    } else {
                        isValid = true;
                    }
                }
                break;
            case "Varna":
            case "Burgas":
                if (hasVIP) {
                    if (pack.equals("withBreakfast")) {
                        price = 130 * 0.88;
                    } else if (pack.equals("noBreakfast")) {
                        price = 100 * 0.92;
                    } else {
                        isValid = true;
                    }
                } else {
                    if (pack.equals("withBreakfast")) {
                        price = 130;
                    } else if (pack.equals("noBreakfast")) {
                        price = 100;
                    } else {
                        isValid = true;
                    }
                }
                break;
            default:
                isValid = true;
                break;
        }
        if (isValid) {
            System.out.println("Invalid input!");
        } else if (days < 1) {
            System.out.println("Days must be positive number!");
        } else {
            double finalPrice = days * price;
            System.out.printf("The price is %.2flv! Have a nice time!", finalPrice);
        }
    }
}


