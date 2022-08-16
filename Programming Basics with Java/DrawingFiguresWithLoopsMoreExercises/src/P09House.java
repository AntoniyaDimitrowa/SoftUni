import java.util.Scanner;

public class P09House {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if(n % 2 == 0) {
            int stars = 2;
            for (int row = 1; row <= n / 2; row++) {
                for(int col = (n - stars) / 2; col >= 1; col--) {
                    System.out.printf("-");
                }
                for(int col = 1; col <= stars; col++) {
                    System.out.printf("*");
                }
                for(int col = (n - stars) / 2; col >= 1; col--) {
                    System.out.printf("-");
                }
                stars += 2;
                System.out.println();
            }

            for (int row = 1; row <= n / 2; row++) {
                for (int col = 1; col <= n; col++) {
                    if(col == 1 || col == n) {
                        System.out.printf("|");
                    } else {
                        System.out.printf("*");
                    }
                }
                System.out.println();
            }
        } else {
            int stars = 1;
            for (int row = 1; row <= Math.ceil(n/2.0); row++) {
                for (int col = (n - stars) / 2; col >= 1; col--) {
                    System.out.printf("-");
                }
                for (int col = 1; col <= stars; col++) {
                    System.out.printf("*");
                }
                for (int col = (n - stars) / 2; col >= 1; col--) {
                    System.out.printf("-");
                }
                stars += 2;
                System.out.println();
            }
            for (int row = 1; row <= Math.floor(n/2.0); row++) {
                for (int col = 1; col <= n; col++) {
                    if(col == 1 || col == n) {
                        System.out.printf("|");
                    } else {
                        System.out.printf("*");
                    }
                }
                System.out.println();
            }
        }
    }
}
