import java.util.Scanner;

public class P08CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radius = Double.parseDouble(scanner.nextLine());

        double area = Math.PI * radius * radius;
        double perimeter = 2 * Math.PI * radius;

        System.out.printf("%.2f %n",area);
        System.out.printf("%.2f",perimeter);
    }
}
