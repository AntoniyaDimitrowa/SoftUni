import java.util.Scanner;

public class P02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        String[][] matrix = generateMatrix(r, c);
        matrixPrint(matrix);
    }

    public static String[][] generateMatrix (int r, int c) {
        char first = 'a';
        char middle = 'a';
        String[][] result = new String[r][c];
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                StringBuilder sb = new StringBuilder();
                sb.append(first);
                sb.append(middle);
                sb.append(first);
                result[row][col] = sb.toString();
                middle = (char)(middle + 1);
            }
            first = (char)(first + 1);
            middle = first;
        }
        return result;
    }
    public static void matrixPrint (String[][] matrix) {
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
