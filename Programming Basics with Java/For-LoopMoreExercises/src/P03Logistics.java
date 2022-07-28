import java.util.Scanner;

public class P03Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loadsCount = Integer.parseInt(scanner.nextLine());
        int totalTons = 0;
        int tonsInVan = 0;
        int tonsInTruck = 0;
        int tonsInTrain = 0;
        double price = 0.0;

        for(int i = 1; i <= loadsCount; i++) {
            int tons = Integer.parseInt(scanner.nextLine());
            totalTons = totalTons + tons;
            if(tons <= 3) {
                tonsInVan = tonsInVan + tons;
                price = price + tons * 200.0;
            } else if(tons <= 11) {
                tonsInTruck = tonsInTruck + tons;
                price = price + tons * 175.0;
            } else if(tons >= 12) {
                tonsInTrain = tonsInTrain + tons;
                price = price + tons * 120.0;
            }
        }

        double average = price / totalTons;
        double vanPercent = (tonsInVan*1.0 / totalTons) * 100.0;
        double truckPercent = (tonsInTruck*1.0 / totalTons) * 100.0;
        double trainPercent = (tonsInTrain*1.0 / totalTons) * 100.0;

        System.out.printf("%.2f%n", average);
        System.out.printf("%.2f%%%n", vanPercent);
        System.out.printf("%.2f%%%n", truckPercent);
        System.out.printf("%.2f%%%n", trainPercent);
    }
}
