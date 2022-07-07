import java.util.Scanner;

public class P07HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double houseHeight = Double.parseDouble(scanner.nextLine());
        double sideWallLength = Double.parseDouble(scanner.nextLine());
        double roofHeight = Double.parseDouble(scanner.nextLine());
        double doorArea = 2 * 1.2;
        double windowsArea = 2 * (1.5 * 1.5);

        //walls
        double frontAndBackWallArea = (2 * houseHeight * houseHeight) - doorArea;
        double sideWallsArea = (2 * houseHeight * sideWallLength) - windowsArea;
        double totalWallsArea = frontAndBackWallArea + sideWallsArea;
        double litersGreenPaint = totalWallsArea / 3.4;

        //roof - 2 rectangles + 2 triangles
        double roofArea = 2 * ((houseHeight * sideWallLength) + ((houseHeight * roofHeight)/2));
        double litersRedPaint = roofArea / 4.3;

        System.out.printf("%.2f %n", litersGreenPaint);
        System.out.printf("%.2f", litersRedPaint);
    }
}
