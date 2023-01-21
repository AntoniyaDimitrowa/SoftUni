import java.util.Scanner;

public class P04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sizes = scanner.nextLine();
        int[][] matrix = matrixReader(sizes, scanner);
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                sum += matrix[row][col];
            }
        }
        System.out.println(sum);
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
