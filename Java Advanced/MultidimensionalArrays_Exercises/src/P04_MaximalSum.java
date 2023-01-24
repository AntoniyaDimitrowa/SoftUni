import java.util.Arrays;
import java.util.Scanner;

public class P04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[0]);
        int[][] matrix = getMatrix(rows, columns, scanner);

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

    public static int[][] findMatrixWithBiggestSum(int[][] matrix) {
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[0].length - 2; col++) {

            }
        }
    }
}
