import java.util.Arrays;
import java.util.Scanner;

public class P04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        int[][] matrix = getMatrix(rows, columns, scanner);
        int[][] matrixWithMaxSum = findMatrixWithMaxSum(matrix);
        int maxSum = getSumOf3x3Matrix(0, 0, matrixWithMaxSum);
        System.out.println("Sum = " + maxSum);
        matrixPrint(matrixWithMaxSum);

    }

    public static int[][] getMatrix(int rows, int columns, Scanner scanner) {
        int[][] result = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < columns; col++) {
                result[row][col] = input[col];
            }
        }
        return result;
    }

    public static int[][] findMatrixWithMaxSum(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int rowMaxSum = 0;
        int columnMaxSum = 0;
        int rows = matrix.length;
        int columns = matrix[2].length;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < columns - 2; col++) {
                int currSum = getSumOf3x3Matrix(row, col, matrix);
                if(maxSum < currSum) {
                    maxSum = currSum;
                    rowMaxSum = row;
                    columnMaxSum = col;
                }
            }
        }
        int[][] result = new int[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                result[row][col] = matrix[rowMaxSum][columnMaxSum];
                columnMaxSum++;
            }
            rowMaxSum++;
            columnMaxSum = columnMaxSum - 3;
        }
        return result;
    }

    public static int getSumOf3x3Matrix(int r, int c, int[][] matrix) {
        int sum = 0;
        for (int row = r; row < r + 3; row++) {
            for (int col = c; col < c + 3; col++) {
                sum = sum + matrix[row][col];
            }
        }
        return sum;
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
