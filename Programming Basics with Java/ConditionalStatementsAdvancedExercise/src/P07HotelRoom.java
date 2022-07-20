import java.util.Scanner;

public class P07HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int nightsCount = Integer.parseInt(scanner.nextLine());

        double priceForApartment = 0.0;
        double priceForStudio = 0.0;

        if(month.equals("May") || month.equals("October")) {
            priceForApartment = nightsCount * 65;
            priceForStudio = nightsCount * 50;
            if(nightsCount > 14) {
                priceForStudio = priceForStudio - priceForStudio * 0.30;
            } else if(nightsCount > 7) {
                priceForStudio = priceForStudio - priceForStudio * 0.05;
            }
        } else if(month.equals("June") || month.equals("September")) {
            priceForApartment = nightsCount * 68.70;
            priceForStudio = nightsCount * 75.20;
            if(nightsCount > 14) {
                priceForStudio = priceForStudio - priceForStudio * 0.20;
            }
        } else if(month.equals("July") || month.equals("August")) {
            priceForApartment = nightsCount * 77;
            priceForStudio = nightsCount * 76;
        }

        if(nightsCount > 14) {
            priceForApartment = priceForApartment - priceForApartment * 0.10;
        }

        System.out.printf("Apartment: %.2f lv.%n", priceForApartment);
        System.out.printf("Studio: %.2f lv.", priceForStudio);


    }
}
