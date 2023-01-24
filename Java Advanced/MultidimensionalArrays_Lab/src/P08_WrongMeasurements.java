import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = getMatrix(rows, scanner);
        int[] wrongElementRowCol = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int wrongElement = matrix[wrongElementRowCol[0]][wrongElementRowCol[1]];
        List<String> wrongElementsPositions = getWrongElements(wrongElement, matrix);
        matrix = changeMatrix(matrix, wrongElementsPositions);
        matrixPrint(matrix);
    }

    public static int[][] getMatrix(int r, Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");
        int[][] result = new int[r][input.length];
        for (int row = 0; row < r; row++) {
            if(row != 0) {
                input = scanner.nextLine().split("\\s+");
            }
            for (int col = 0; col < input.length; col++) {
                result[row][col] = Integer.parseInt(input[col]);
            }
        }
        return result;
    }

    public static List<String> getWrongElements(int wrongElement, int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        List<String> result = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if(matrix[row][col] == wrongElement) {
                    result.add(row + " " + col);
                }
            }
        }
        return result;
    }

    public static int[][] changeMatrix(int[][] matrix, List<String> positions) {
        for (int i = 0; i < positions.size(); i++) {
            int row = Integer.parseInt(positions.get(i).split("\\s+")[0]);
            int column = Integer.parseInt(positions.get(i).split("\\s+")[1]);
            int elementUp = 0;
            if(row - 1 >= 0) {
                if(!positions.contains((row - 1) + " " + column)) {
                    elementUp = matrix[row - 1][column];
                }
            }

            int elementDown = 0;
            if(row + 1 < matrix.length) {
                if(!positions.contains((row + 1) + " " + column)) {
                    elementDown = matrix[row + 1][column];
                }
            }

            int elementLeft = 0;
            if(column - 1 >= 0) {
                if(!positions.contains(row + " " + (column - 1))) {
                    elementLeft = matrix[row][column - 1];
                }
            }

            int elementRight = 0;
            if(column + 1 < matrix[0].length) {
                if(!positions.contains(row + " " + (column + 1))){
                    elementRight = matrix[row][column + 1];
                }
            }
            matrix[row][column] = elementRight + elementLeft + elementDown + elementUp;
        }
        return matrix;
    }

    public static void matrixPrint (int[][] matrix) {
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
