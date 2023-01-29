import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P07_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        int[][] matrix = fillingMatrix(rows, columns);
        String command = scanner.nextLine();
        while(!command.equals("Nuke it from orbit")) {
            int row = Integer.parseInt(command.split("\\s+")[0]);
            int col = Integer.parseInt(command.split("\\s+")[1]);
            int radius = Integer.parseInt(command.split("\\s+")[2]);
            if(row < matrix.length && col < matrix[0].length && row >= 0 && col >= 0) {
                matrix = destroyCells(row, col, radius, matrix);
            } else if((row < 0 && col < 0) || (row >= matrix.length && col >= matrix[0].length) || (row >= matrix.length && col < 0) || (row < 0 && col >= matrix[0].length)) {
                command = scanner.nextLine();
                continue;
            } else if((row < matrix.length && row >= 0) && (col < 0 || col >= matrix[0].length)) {
                for (int i = 1; i <= radius; i++) {
                    if(col+i < matrix[0].length && col+i >= 0) {
                        matrix[row][col+i] = 0;
                    }
                    if(col-i >= 0 && col-i < matrix[0].length) {
                        matrix[row][col-i] = 0;
                    }
                }
            } else if((col < matrix[0].length && col >= 0) && (row < 0 || row >= matrix.length)) {
                for (int i = 1; i <= radius; i++) {
                    if(row+i < matrix.length && row+i >= 0) {
                        matrix[row][col] = 0;
                    }
                    if(row-i >= 0 && row-i < matrix.length) {
                        matrix[row-i][col] = 0;
                    }

                }
            }
            command = scanner.nextLine();
        }
        matrixPrint(matrix);

    }

    public static int[][] fillingMatrix(int r, int c) {
        int[][] result = new int[r][c];
        int num = 1;

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                result[row][col] = num;
                num++;
            }
        }

        return result;
    }

    public static int[][] destroyCells(int r, int c, int radius, int[][] matrix) {
        matrix[r][c] = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 1; i <= radius; i++) {
            if(r+i < rows) {
                matrix[r+i][c] = 0;
            }
            if(r-i >= 0) {
                matrix[r-i][c] = 0;
            }
            if(c+i < columns) {
                matrix[r][c+i] = 0;
            }
            if(c-i >= 0) {
                matrix[r][c-i] = 0;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if(matrix[row][col] != 0) {
                    list.add(matrix[row][col]);
                }
            }

            for (int col = 0; col < columns; col++) {
                if(col < list.size()) {
                    matrix[row][col] = list.get(col);
                } else {
                    matrix[row][col] = 0;
                }
            }
            list.clear();
        }
        return matrix;
    }

    public static void matrixPrint (int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if(matrix[row][col] != 0) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }
}
