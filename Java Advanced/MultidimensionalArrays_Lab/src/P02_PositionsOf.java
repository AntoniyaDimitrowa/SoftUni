import java.util.Arrays;
import java.util.Scanner;

public class P02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsColumns = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = rowsColumns[0];
        int columns = rowsColumns[1];
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean isFound = false;
        int num = Integer.parseInt(scanner.nextLine());
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if(num == matrix[row][col]) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }

        if(!isFound) {
            System.out.println("not found");
        }
    }
}
