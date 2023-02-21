package P02_PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rectanglePoints = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point bottomLeft = new Point(rectanglePoints[0], rectanglePoints[1]);
        Point topRight = new Point(rectanglePoints[2], rectanglePoints[3]);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int numberOfPoints = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfPoints; i++) {
            String coordinates = scanner.nextLine();
            Point currPoint = PointUtil.parsePoint(coordinates);
            System.out.println(rectangle.contains(currPoint));

        }
    }
}
