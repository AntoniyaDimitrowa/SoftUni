import java.util.Scanner;

public class P07AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shape = scanner.nextLine();
        double area = 0;

        if(shape.equals("square")) {
            double side = Double.parseDouble(scanner.nextLine());
            area = side * side;
        }
        else if(shape.equals("rectangle")) {
            double side1 = Double.parseDouble(scanner.nextLine());
            double side2 = Double.parseDouble(scanner.nextLine());
            area = side1 * side2;
        }
        else if(shape.equals("triangle")) {
            double side = Double.parseDouble(scanner.nextLine());
            double height = Double.parseDouble(scanner.nextLine());
            area = (side * height) / 2;
        }
        else if(shape.equals("circle")) {
            double radius = Double.parseDouble(scanner.nextLine());
            area = Math.PI * radius * radius;
        }
        System.out.printf("%.3f",area);
    }
}
