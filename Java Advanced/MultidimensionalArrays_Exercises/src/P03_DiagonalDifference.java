import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;

public class P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = getSquareMatrix(rows, scanner);
        int sumPrimaryDiagonal = getSumPrimaryDiagonal(matrix);
        int sumSecondaryDiagonal = getSumSecondaryDiagonal(matrix);
        System.out.println(Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal));
    }

    public static int[][] getSquareMatrix(int rows, Scanner scanner) {
        int[][] result = new int[rows][rows];
        for (int row = 0; row < rows; row++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < rows; col++) {
                result[row][col] = input[col];
            }
        }
        return result;
    }

    public static int getSumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum += matrix[row][row];
        }
        return sum;
    }

    public static int getSumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        int col = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            sum += matrix[row][col];
            col++;
        }
        return sum;
    }
}
