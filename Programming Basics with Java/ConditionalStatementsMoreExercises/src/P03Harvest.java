import java.util.Scanner;

public class P03Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int areaOfVineyardInSqM = Integer.parseInt(scanner.nextLine());
        double kilosGrapesOfOneSqM = Double.parseDouble(scanner.nextLine());
        int neededLitersWine = Integer.parseInt(scanner.nextLine());
        int workersCount = Integer.parseInt(scanner.nextLine());

        double totalKilosGrapes = kilosGrapesOfOneSqM * areaOfVineyardInSqM;
        double kilosGrapesForWine = totalKilosGrapes * 0.4;
        double litersWineProduced = kilosGrapesForWine / 2.5;

        if(neededLitersWine > litersWineProduced) {
            double missingWine = neededLitersWine - litersWineProduced;
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(missingWine));
        } else {
            double remainingWine = litersWineProduced - neededLitersWine;
            double wineForOneWorker = remainingWine / workersCount;
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", Math.floor(litersWineProduced));
            System.out.printf("%.0f liters left -> %.0f liters per person.", Math.ceil(remainingWine), Math.ceil(wineForOneWorker));
        }
    }
}
