import java.util.Scanner;

public class P02_BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        int blindManRow = 0;
        int blindManColumn = 0;
        int playersTouched = 0;
        int movesCount = 0;

        String[][] playground = new String[rows][columns];
        for (int row = 0; row < rows; row++) {
            String[] currRow = scanner.nextLine().split(" ");
            for (int col = 0; col < columns; col++) {
                playground[row][col] = currRow[col];
                if(currRow[col].equals("B")) {
                    blindManRow = row;
                    blindManColumn = col;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            if(playersTouched == 3) {
                break;
            }
            switch (command) {
                case "up":
                    blindManRow--;
                    if(isOutOfPlayground(blindManRow, blindManColumn, playground) || isObstacle(blindManRow, blindManColumn, playground)) {
                        blindManRow++;
                    } else {
                        if (isPlayer(blindManRow, blindManColumn, playground)) {
                            playersTouched++;
                            playground[blindManRow][blindManColumn] = "-";
                        }
                        movesCount++;
                    }
                    break;
                case "down":
                    blindManRow++;
                    if(isOutOfPlayground(blindManRow, blindManColumn, playground) || isObstacle(blindManRow, blindManColumn, playground)) {
                        blindManRow--;
                    } else {
                        if (isPlayer(blindManRow, blindManColumn, playground)) {
                            playersTouched++;
                            playground[blindManRow][blindManColumn] = "-";
                        }
                        movesCount++;
                    }
                    break;
                case "right":
                    blindManColumn++;
                    if(isOutOfPlayground(blindManRow, blindManColumn, playground) || isObstacle(blindManRow, blindManColumn, playground)) {
                        blindManColumn--;
                    } else {
                        if (isPlayer(blindManRow, blindManColumn, playground)) {
                            playersTouched++;
                            playground[blindManRow][blindManColumn] = "-";
                        }
                        movesCount++;
                    }
                    break;
                case "left":
                    blindManColumn--;
                    if(isOutOfPlayground(blindManRow, blindManColumn, playground) || isObstacle(blindManRow, blindManColumn, playground)) {
                        blindManColumn++;
                    } else {
                        if (isPlayer(blindManRow, blindManColumn, playground)) {
                            playersTouched++;
                            playground[blindManRow][blindManColumn] = "-";
                        }
                        movesCount++;
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", playersTouched, movesCount);

    }

    private static boolean isObstacle(int rowOfBlindMan, int columnOfBlindMan, String[][] playground) {
        if (playground[rowOfBlindMan][columnOfBlindMan].equals("O")) {
            return true;
        }
        return false;
    }

    private static boolean isPlayer(int rowOfBlindMan, int columnOfBlindMan, String[][] playground) {
        if (playground[rowOfBlindMan][columnOfBlindMan].equals("P")) {
            return true;
        }
        return false;
    }

    private static boolean isOutOfPlayground(int rowOfY, int colOfY, String[][] playground) {
        int rows = playground.length;
        int cols = playground[0].length;
        if(rowOfY < 0 || colOfY < 0 || rowOfY >= rows || colOfY >= cols) {
            return true;
        }
        return false;
    }
}
