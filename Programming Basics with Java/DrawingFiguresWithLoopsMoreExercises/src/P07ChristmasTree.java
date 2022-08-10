import java.util.Scanner;

public class P07ChristmasTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for(int row = 0; row < n; row++) {
            if(row == 0) {
                for(int col = n+1; col >= 1; col--) {
                    System.out.printf(" ");
                }
                System.out.printf("| ");

            } else {
                for (int col = n - row; col >= 1; col--) {
                    System.out.printf(" ");
                }
                for (int col = 1; col <= row + 1; col++) {
                    System.out.printf("* ");
                }
                System.out.printf("| ");
                for (int col = 1; col <= row + 1; col++) {
                    System.out.printf("* ");
                }
            }
            System.out.println();
        }
    }
}
