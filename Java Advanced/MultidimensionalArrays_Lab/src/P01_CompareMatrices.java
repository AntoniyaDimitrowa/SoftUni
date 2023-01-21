import java.util.Arrays;
import java.util.Scanner;

public class P01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsColumns1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rowsMatrix1 = rowsColumns1[0];
        int columnsMatrix1 = rowsColumns1[1];
        int[][] matrix1 = new int[rowsMatrix1][columnsMatrix1];

        for (int i = 0; i < rowsMatrix1; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int j = 0; j < columnsMatrix1; j++) {
                matrix1[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[] rowsColumns2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rowsMatrix2 = rowsColumns2[0];
        int columnsMatrix2 = rowsColumns2[1];
        int[][] matrix2 = new int[rowsMatrix2][columnsMatrix2];

        for (int i = 0; i < rowsMatrix2; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int j = 0; j < columnsMatrix2; j++) {
                matrix2[i][j] = Integer.parseInt(input[j]);
            }
        }

        if(matricesAreEqual(matrix1, matrix2)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    public static boolean matricesAreEqual(int[][] m1, int[][] m2) {
        if(m1.length != m2.length) {
            return false;
        } else {
            for (int i = 0; i < m1.length; i++) {
                if(m1[i].length != m2[i].length) {
                    return false;
                } else {
                    for (int j = 0; j < m1[i].length; j++) {
                        if (m1[i][j] != m2[i][j]) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}
