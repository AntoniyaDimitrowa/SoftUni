import java.util.Scanner;

public class P01_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            printRow(i, n-i);
        }

        for (int i = n-1; i >= 1; i--) {
            System.out.println(getRow(i, n-i));
        }
    }

    public static String getRow(int numberOfStars, int numberOfLeadingSpaces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfLeadingSpaces; i++) {
            sb.append(" ");
        }
        for (int i = 0; i < numberOfStars - 1; i++) {
            sb.append("* ");
        }
        sb.append("*");
        return sb.toString();
    }

    public static void printRow(int numberOfStars, int numberOfLeadingSpaces) {
        for (int i = 0; i < numberOfLeadingSpaces; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < numberOfStars - 1; i++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }
}
