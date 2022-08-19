import java.util.Scanner;

public class P10Diamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int leftRight = (n-1)/2;
        int mid = n - 2 * leftRight - 2;

        if(n % 2 == 0) {
            for(int row = 1; row <= n/2; row++) {
                for(int col = leftRight; col >= 1; col--) {
                    System.out.printf("-");
                }
                System.out.printf("*");
                for(int col = 1; col <= mid ; col++) {
                    System.out.printf("-");
                }
                System.out.printf("*");
                for(int col = leftRight; col >= 1; col--) {
                    System.out.printf("-");
                }
                if(row < n/2) {
                    leftRight--;
                    mid += 2;
                }
                System.out.println();
            }
            leftRight++;
            mid -= 2;
            for(int row = 1; row <= (n/2)-1; row++) {
                for(int col = 1; col <= leftRight; col++) {
                    System.out.printf("-");
                }
                System.out.printf("*");
                for(int col = 1; col <= mid ; col++) {
                    System.out.printf("-");
                }
                System.out.printf("*");
                for(int col = 1; col <= leftRight; col++) {
                    System.out.printf("-");
                }
                leftRight++;
                mid -= 2;
                System.out.println();
            }
        } else {
            for(int row = 1; row <= Math.ceil(n/2.0); row++) {
                for(int col = leftRight; col >= 1; col--) {
                    System.out.printf("-");
                }
                System.out.printf("*");
                for(int col = 1; col <= mid ; col++) {
                    System.out.printf("-");
                }
                if(mid>0) {
                    System.out.printf("*");
                }
                for(int col = leftRight; col >= 1; col--) {
                    System.out.printf("-");
                }
                if(row<Math.ceil(n/2.0)) {
                    leftRight--;
                    mid += 2;
                }
                System.out.println();
            }
            leftRight++;
            mid -= 2;
            for(int row = 1; row <= Math.floor(n/2.0); row++) {
                for(int col = 1; col <= leftRight; col++) {
                    System.out.printf("-");
                }
                System.out.printf("*");
                for(int col = 1; col <= mid ; col++) {
                    System.out.printf("-");
                }
                if(mid>0) {
                    System.out.printf("*");
                }
                for(int col = 1; col <= leftRight; col++) {
                    System.out.printf("-");
                }
                leftRight++;
                mid -= 2;
                System.out.println();
            }
        }
    }
}
