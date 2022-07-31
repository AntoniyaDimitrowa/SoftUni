import java.util.Scanner;

public class P07FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stadiumCapacity = Integer.parseInt(scanner.nextLine());
        int fansCount = Integer.parseInt(scanner.nextLine());
        int sectorA = 0;
        int sectorB = 0;
        int sectorV = 0;
        int sectorG = 0;

        for (int i = 1; i <= fansCount; i++) {
            String sector = scanner.nextLine();
            switch (sector) {
                case "A":
                    sectorA++;
                    break;
                case "B":
                    sectorB++;
                    break;
                case "V":
                    sectorV++;
                    break;
                case "G":
                    sectorG++;
                    break;
            }
        }

        double sectorAPercent = sectorA * 1.0 / fansCount * 100;
        double sectorBPercent = sectorB * 1.0 / fansCount * 100;
        double sectorVPercent = sectorV * 1.0 / fansCount * 100;
        double sectorGPercent = sectorG * 1.0 / fansCount * 100;
        double fansPercent = fansCount * 1.0 / stadiumCapacity * 100;

        System.out.printf("%.2f%%%n", sectorAPercent);
        System.out.printf("%.2f%%%n", sectorBPercent);
        System.out.printf("%.2f%%%n", sectorVPercent);
        System.out.printf("%.2f%%%n", sectorGPercent);
        System.out.printf("%.2f%%%n", fansPercent);
    }
}
