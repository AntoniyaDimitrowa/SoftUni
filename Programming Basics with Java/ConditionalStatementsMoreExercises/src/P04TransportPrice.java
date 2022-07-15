import java.util.Scanner;

public class P04TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfKilometers = Integer.parseInt(scanner.nextLine());
        String dayOrNight = scanner.nextLine();
        double priceWithTaxi = Double.MAX_VALUE;
        double priceWithBus = Double.MAX_VALUE;
        double priceWithTrain = Double.MAX_VALUE;

        if(dayOrNight.equals("day")) {
            if(numberOfKilometers < 20) {
                priceWithTaxi = 0.70 + (0.79 * numberOfKilometers);
            } else if(numberOfKilometers < 100) {
                priceWithTaxi = 0.79 * numberOfKilometers;
                priceWithBus = 0.09 * numberOfKilometers;
            }
            else {
                priceWithTaxi = 0.70 + (0.79 * numberOfKilometers);
                priceWithBus = 0.09 * numberOfKilometers;
                priceWithTrain = 0.06 * numberOfKilometers;
            }
        }
        else if(dayOrNight.equals("night")) {
            if(numberOfKilometers < 20) {
                priceWithTaxi = 0.70 + (0.90 * numberOfKilometers);
            } else if(numberOfKilometers < 100) {
                priceWithTaxi = 0.90 * numberOfKilometers;
                priceWithBus = 0.09 * numberOfKilometers;
            }
            else {
                priceWithTaxi = 0.70 + (0.90 * numberOfKilometers);
                priceWithBus = 0.09 * numberOfKilometers;
                priceWithTrain = 0.06 * numberOfKilometers;
            }
        }

        double lowestPrice = Double.min(priceWithTaxi,priceWithBus);
        lowestPrice = Double.min(lowestPrice,priceWithTrain);

        System.out.printf("%.2f",lowestPrice);
    }
}
