import java.util.Arrays;
import java.util.Scanner;

public class P05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        String[][] matrix = getMatrix(rows, columns, scanner);
        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("END")) {
            if(!command[0].equals("swap")) {
                System.out.println("Invalid input!");
            } else {
                if(command.length != 5) {
                    System.out.println("Invalid input!");
                } else {
                    int r1 = Integer.parseInt(command[1]);
                    int c1 = Integer.parseInt(command[2]);
                    int r2 = Integer.parseInt(command[3]);
                    int c2 = Integer.parseInt(command[4]);
                    if(r1 < 0 || r1 >= matrix.length || r2 < 0 || r2 >= matrix.length || c1 < 0 || c1 >= matrix[0].length || c2 < 0 || c2 >= matrix[0].length) {
                        System.out.println("Invalid input!");
                    } else {
                        matrix = swapElements(r1, c1, r2, c2, matrix);
                        matrixPrint(matrix);
                    }
                }
            }
            command = scanner.nextLine().split("\\s+");
        }
    }

    public static String[][] getMatrix(int rows, int columns, Scanner scanner) {
        String[][] result = new String[rows][columns];
        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < columns; col++) {
                result[row][col] = input[col];
            }
        }
        return result;
    }
    public static String[][] swapElements(int r1, int c1, int r2, int c2, String[][] matrix) {
        String temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] =  temp;
        return matrix;
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
