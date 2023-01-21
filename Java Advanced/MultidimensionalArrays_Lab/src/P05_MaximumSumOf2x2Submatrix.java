import java.util.Scanner;

public class P05_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sizes = scanner.nextLine();
        int[][] matrix = matrixReader(sizes, scanner);
        int biggestSum = Integer.MIN_VALUE;
        int resultRow = 0;
        int resultColumn = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[0].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col+1] + matrix[row+1][col] + matrix[row+1][col+1];
                if(sum > biggestSum) {
                    biggestSum = sum;
                    resultRow = row;
                    resultColumn = col;
                }
            }
        }

        System.out.println(matrix[resultRow][resultColumn] + " " + matrix[resultRow][resultColumn+1]);
        System.out.println(matrix[resultRow+1][resultColumn] + " " + matrix[resultRow+1][resultColumn+1]);
        System.out.println(biggestSum);
    }
    private static int[][] matrixReader(String sizes, Scanner scanner) {
        int rows = Integer.parseInt(sizes.split(",\\s+")[0]);
        int columns = Integer.parseInt(sizes.split(",\\s+")[1]);
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            String[] inputLine = scanner.nextLine().split(",\\s+");
            for (int col = 0; col < columns; col++) {
                matrix[row][col] = Integer.parseInt(inputLine[col]);
            }
        }
        return matrix;
    }
}
