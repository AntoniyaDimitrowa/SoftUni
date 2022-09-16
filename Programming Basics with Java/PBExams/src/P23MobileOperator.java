import java.util.Scanner;

public class P23MobileOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String contractPeriod = scanner.nextLine();
        String contractType = scanner.nextLine();
        String mobileInternetAdded = scanner.nextLine();
        int monthsForPaying = Integer.parseInt(scanner.nextLine());
        double priceForOneMonth = 0.0;
        if(contractPeriod.equals("one")) {
            switch(contractType) {
                case "Small":
                    priceForOneMonth = 9.98;
                    break;
                case "Middle":
                    priceForOneMonth = 18.99;
                    break;
                case "Large":
                    priceForOneMonth = 25.98;
                    break;
                case "ExtraLarge":
                    priceForOneMonth = 35.99;
                    break;
            }
        } else if(contractPeriod.equals("two")) {
            switch(contractType) {
                case "Small":
                    priceForOneMonth = 8.58;
                    break;
                case "Middle":
                    priceForOneMonth = 17.09;
                    break;
                case "Large":
                    priceForOneMonth = 23.59;
                    break;
                case "ExtraLarge":
                    priceForOneMonth = 31.79;
                    break;
            }
        }

        if(mobileInternetAdded.equals("yes")) {
            if(priceForOneMonth <= 10) {
                priceForOneMonth += 5.50;
            } else if(priceForOneMonth <= 30) {
                priceForOneMonth += 4.35;
            } else {
                priceForOneMonth += 3.85;
            }
        }

        if(contractPeriod.equals("two")) {
            priceForOneMonth = priceForOneMonth - priceForOneMonth * 0.0375;
        }

        System.out.printf("%.2f lv.", priceForOneMonth * monthsForPaying);
    }
}
