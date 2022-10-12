import java.util.Scanner;

public class P07_NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        printMatrix(num);
    }
    public static void printMatrix(int num) {
        for (int row = 0; row < num; row++) {
            for (int col = 0; col < num; col++) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }
}
