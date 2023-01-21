import java.util.Scanner;

public class P03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        char[][] matrix1 = new char[rows][columns];
        char[][] matrix2 = new char[rows][columns];
        char[][] matrix3 = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            for (int col = 0; col < columns; col++) {
                matrix1[row][col] = inputLine[col].charAt(0);
            }
        }

        for (int row = 0; row < rows; row++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            for (int col = 0; col < columns; col++) {
                matrix2[row][col] = inputLine[col].charAt(0);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if(matrix1[row][col] == matrix2[row][col]) {
                    matrix3[row][col] = matrix1[row][col];
                } else {
                    matrix3[row][col] = '*';
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(matrix3[row][col] + " ");
            }
            System.out.println();
        }
    }
}
