package P05_JediGalaxy.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] galaxyMatrix = readAndInitializeMatrix(scanner);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediCoords = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoords = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            moveEvilAndDestroyStars(galaxyMatrix, evilCoords);
            sum += moveJediAndAddStars(galaxyMatrix, jediCoords);

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }

    private static long moveJediAndAddStars(int[][] galaxyMatrix, int[] jediCoords) {
        int jediRow = jediCoords[0];
        int jediCol = jediCoords[1];

        long sum = 0;
        while (canJediStillMove(galaxyMatrix, jediRow, jediCol)) {
            if (jediRow >= 0 && jediRow < galaxyMatrix.length && jediCol >= 0 && jediCol < galaxyMatrix[0].length) {
                sum += galaxyMatrix[jediRow][jediCol];
            }

            jediRow--;
            jediCol++;
        }
        return sum;
    }

    private static boolean canJediStillMove(int[][] galaxyMatrix, int jediRow, int jediCol) {
        return jediRow >= 0 && jediCol < galaxyMatrix[1].length;
    }

    private static void moveEvilAndDestroyStars(int[][] galaxyMatrix, int[] evilCoords) {
        int evilRow = evilCoords[0];
        int evilCol = evilCoords[1];

        while (canEvilStillMove(evilRow, evilCol)) {
            if (evilRow >= 0 && evilRow < galaxyMatrix.length && evilCol >= 0 && evilCol < galaxyMatrix[0].length) {
                galaxyMatrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static boolean canEvilStillMove(int evilRow, int evilCol) {
        return evilRow >= 0 && evilCol >= 0;
    }

    private static int[][] readAndInitializeMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];

        int[][] matrix = new int[rows][columns];

        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }
}
