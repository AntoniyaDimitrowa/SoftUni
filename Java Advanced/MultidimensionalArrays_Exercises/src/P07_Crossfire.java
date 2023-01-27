import java.util.ArrayList;
import java.util.Collections;
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
            int col = Integer.parseInt(command.split("\\s+")[0]);
            int radius = Integer.parseInt(command.split("\\s+")[0]);
            matrix = destroyCells(row, col, radius, matrix);
        }

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
                list.add(matrix[row][col]);
            }
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) == 0) {
                    list.remove(i);
                    i--;
                }
            }
            for (int col = 0; col < columns; col++) {
                if(col < list.size()) {
                    matrix[row][col] = list.get(col);
                } else {
                    matrix[row][col] = "";
                }
            }
        }
    }
}
