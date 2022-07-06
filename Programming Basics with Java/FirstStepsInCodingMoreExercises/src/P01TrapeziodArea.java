import java.util.Scanner;

public class P01TrapeziodArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstBase = Double.parseDouble(scanner.nextLine());
        double secondBase = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        double area = ((firstBase + secondBase) * height)/2;
        System.out.printf("%.2f",area);
    }
}
