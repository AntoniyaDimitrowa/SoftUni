import java.util.Scanner;

public class P01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s+");
        int rows = Integer.parseInt(input[0]);
        int[][] matrix = new int[rows][];
        if(input[1].equals("A")) {
            matrix = fillingMatrixFirstWay(rows);
        } else if(input[1].equals("B")) {
            matrix = fillingMatrixSecondWay(rows);
        }
        matrixPrint(matrix);
    }

    public static int[][] fillingMatrixFirstWay(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                result[row][col] = num;
                num++;
            }
        }
        return result;
    }

    public static int[][] fillingMatrixSecondWay(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        for (int col = 0; col < n; col++) {
            if(col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    result[row][col] = num;
                    num++;
                }
            } else {
                for (int row = n - 1; row >= 0; row--) {
                    result[row][col] = num;
                    num++;
                }
            }
        }
        return result;
    }

    public static void matrixPrint (int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
