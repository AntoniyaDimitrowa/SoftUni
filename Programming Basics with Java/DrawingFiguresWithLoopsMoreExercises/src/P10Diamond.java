import java.util.Scanner;

public class P10Diamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        if(n % 2 == 0)  {
            int stars = 2;

        } else {
            int stars = 1;
            for(int row = 1; row <= Math.ceil(n/2.0); row++) {
                for(int col = n-row; col >= 1; col--) {
                    System.out.printf("-");
                }
                for(int col = 1; col <= row; col++) {
                    System.out.printf("*");
                }
                for(int col = n-row; col >= 1; col--) {
                    System.out.printf("-");
                }

                System.out.println();
            }
            for(int row = 1; row <= Math.floor(n/2.0); row++) {
                for(int col = 1; col <= row; col++) {
                    System.out.printf("-");
                }
                for(int col = n-row; col >= 1; col--) {
                    System.out.printf("*");
                }
                for(int col = 1; col <= row; col++) {
                    System.out.printf("-");
                }
                System.out.println();
            }
        }
    }
}
