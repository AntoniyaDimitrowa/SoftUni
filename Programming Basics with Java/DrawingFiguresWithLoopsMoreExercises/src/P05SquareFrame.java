import java.util.Scanner;

public class P05SquareFrame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= n; col++) {
                if((row==1 && col==1) || (row==n && col==n) || (row==1 && col==n) || (row==n && col==1)) {
                    System.out.printf("+ ");
                } else if(col==1 || col == n) {
                    System.out.printf("| ");
                } else {
                    System.out.printf("- ");
                }
            }
            System.out.println();
        }
    }
}
