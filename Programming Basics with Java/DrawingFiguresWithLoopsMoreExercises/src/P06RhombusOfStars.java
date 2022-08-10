
import java.util.Scanner;

public class P06RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for(int row = 1; row <= n; row++) {
            for(int col = n-row; col >= 1; col--) {
                System.out.printf(" ");
            }
            for(int col = 1; col <= row; col++) {
                System.out.printf("* ");
            }
            System.out.println();
        }
        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= row; col++) {
                System.out.printf(" ");
            }
            for(int col = n-row; col >= 1; col--) {
                System.out.printf("* ");
            }
            System.out.println();
        }
    }
}