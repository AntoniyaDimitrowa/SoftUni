package P02_PointInRectangle;

public class PointUtil {

    public static Point parsePoint(String input) {
        String[] coordinates = input.split("\\s+");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        return new Point(x, y);
    }
}
