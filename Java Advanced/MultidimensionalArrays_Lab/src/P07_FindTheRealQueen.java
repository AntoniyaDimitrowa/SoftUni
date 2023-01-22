import java.util.Scanner;

public class P07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = squareMatrixReader(8, scanner);
        boolean queenIsFound = false;
        int queenRow = 0;
        int queenColumn = 0;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if(!queenIsFound) {
                    if (matrix[row][col] == 'q') {
                        queenIsFound = true;
                        queenRow = row;
                        queenColumn = col;
                    }
                } else {
                    if (matrix[row][col] == 'q') {
                        queenIsFound = false;
                        break;
                    } else {
                        for (int row1 = 0; row1 < 8; row1++) {
                            if(matrix[row1][queenColumn] == 'q') {
                                queenIsFound = false;
                                break;
                            }
                        }
                        for (int row2 = queenRow + 1; row2 < 8; row2++) {
                            int col2 = queenColumn + 1;
                            if(matrix[row2][col2] == 'q') {
                                queenIsFound = false;
                                break;
                            }
                            col2++;
                        }
                        for (int row3 = queenRow - 1; row3 >= 0; row3--) {
                            int col3 = queenColumn - 1;
                            if(matrix[row3][col3] == 'q') {
                                queenIsFound = false;
                                break;
                            }
                            col3--;
                        }
                        System.out.println(queenRow + " " + queenColumn);
                        break;
                    }
                }

            }
        }
    }

    private static char[][] squareMatrixReader(int n, Scanner scanner) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = inputLine[col].charAt(0);
            }
        }
        return matrix;
    }
}
