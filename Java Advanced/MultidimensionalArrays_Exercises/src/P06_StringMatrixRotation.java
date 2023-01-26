import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split("\\(");
        String inputLine = scanner.nextLine();
        List<String> list = new ArrayList<>();
        while (!inputLine.equals("END")) {
            list.add(inputLine);
            inputLine = scanner.nextLine();
        }
        int matrixRows = list.size();
        int matrixColumn = getMaxColumns(list);
        char[][] matrix = getMatrix(matrixRows, matrixColumn, list);

        if(command[1].equals("90)")) {
            char[][] resultMatrix = rotate90(matrix);
            matrixPrint(resultMatrix);
        } else if(command[1].equals("180)")) {
            char[][] resultMatrix = rotate180(matrix);
            matrixPrint(resultMatrix);
        } else if(command[1].equals("270)")) {
            char[][] resultMatrix = rotate270(matrix);
            matrixPrint(resultMatrix);
        }
    }

    public static int getMaxColumns(List<String> list) {
        int maxCol = Integer.MIN_VALUE;
        for (String s : list) {
            if(maxCol < s.length()) {
                maxCol = s.length();
            }
        }
        return maxCol;
    }
    public static char[][] getMatrix(int rows, int columns, List<String> list) {
        char[][] result = new char[rows][columns];
        for (int row = 0; row < rows; row++) {
            String currWord = list.get(row);
            for (int col = 0; col < columns; col++) {
                if(currWord.length() > col) {
                    result[row][col] = currWord.charAt(col);
                } else {
                    result[row][col] = ' ';
                }
            }
        }
        return result;
    }

    public static char[][] rotate90(char[][] matrix) {
        char[][] result = new char[matrix[0].length][matrix.length];
        int matrixRow = matrix.length - 1;
        int matrixCol = 0;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[0].length; row++) {
                result[row][col] = matrix[matrixRow][matrixCol];
                matrixCol++;
            }
            matrixRow--;
            matrixCol = matrixCol - matrix[0].length;
        }
        return result;
    }

    public static char[][] rotate180(char[][] matrix) {
        char[][] result = new char[matrix.length][matrix[0].length];
        int matrixRow = matrix.length - 1;
        int matrixCol = matrix[0].length - 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                result[row][col] = matrix[matrixRow][matrixCol];
                matrixCol--;
            }
            matrixRow--;
            matrixCol = matrixCol + matrix[0].length;
        }
        return result;
    }

    public static char[][] rotate270(char[][] matrix) {
        char[][] result = new char[matrix[0].length][matrix.length];
        int matrixRow = 0;
        int matrixCol = matrix[0].length - 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[0].length; row++) {
                result[row][col] = matrix[matrixRow][matrixCol];
                matrixCol--;
            }
            matrixRow++;
            matrixCol = matrixCol + matrix[0].length;
        }
        return result;
    }

    public static void matrixPrint (char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
