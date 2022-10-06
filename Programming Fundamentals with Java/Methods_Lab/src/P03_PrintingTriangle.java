import java.util.Scanner;

public class P03_PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i < n; i++) {
            printLine(i);
        }

        for (int i = n; i >= 1; i--) {
            printLine(i);
        }
    }
    public static void printLine(int end) {
        for (int i = 1; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
