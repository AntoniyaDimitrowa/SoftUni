import java.util.Scanner;

public class P06_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = squareMatrixReader(n, scanner);

        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        int col = 0;
        for (int i = n-1; i >= 0; i--) {
            System.out.print(matrix[i][col] + " ");
            col++;
        }
    }

    private static int[][] squareMatrixReader(int n, Scanner scanner) {
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = Integer.parseInt(inputLine[col]);
            }
        }
        return matrix;
    }
}
