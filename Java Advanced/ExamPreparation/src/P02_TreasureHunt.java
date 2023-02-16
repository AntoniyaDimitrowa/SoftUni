import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        int rowOfY = 0;
        int columnOfY = 0;

        List<String> commandsList = new ArrayList<>();

        String[][] field = new String[rows][columns];
        for (int row = 0; row < rows; row++) {
            String[] currRow = scanner.nextLine().split("\\s+");
            for (int col = 0; col < columns; col++) {
                field[row][col] = currRow[col];
                if(currRow[col].equals("Y")) {
                    rowOfY = row;
                    columnOfY = col;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            if(command.equals("up")) {
                rowOfY--;
                if(isOutOfField(rowOfY, columnOfY, field.length, field[0].length) || isTree(rowOfY, columnOfY, field)) {
                    rowOfY++;
                } else {
                    if(field[rowOfY + 1][columnOfY].equals("X/Y")) {
                        field[rowOfY + 1][columnOfY] = "X";
                    } else {
                        field[rowOfY + 1][columnOfY] = "-";
                    }
                    commandsList.add(command);
                }

            } else if(command.equals("down")) {
                rowOfY++;
                if(isOutOfField(rowOfY, columnOfY, field.length, field[0].length) || isTree(rowOfY, columnOfY, field)) {
                    rowOfY--;
                } else {
                    if(field[rowOfY - 1][columnOfY].equals("X/Y")) {
                        field[rowOfY - 1][columnOfY] = "X";
                    } else {
                        field[rowOfY - 1][columnOfY] = "-";
                    }
                    commandsList.add(command);
                }
            } else if(command.equals("right")) {
                columnOfY++;
                if(isOutOfField(rowOfY, columnOfY, field.length, field[0].length) || isTree(rowOfY, columnOfY, field)) {
                    columnOfY--;
                } else {
                    if( field[rowOfY][columnOfY - 1].equals("X/Y")) {
                        field[rowOfY][columnOfY - 1] = "X";
                    } else {
                        field[rowOfY][columnOfY - 1] = "-";
                    }
                    commandsList.add(command);
                }
            } else if(command.equals("left")) {
                columnOfY--;
                if(isOutOfField(rowOfY, columnOfY, field.length, field[0].length) || isTree(rowOfY, columnOfY, field)) {
                    columnOfY++;
                } else {
                    if( field[rowOfY][columnOfY + 1].equals("X/Y")) {
                        field[rowOfY][columnOfY + 1] = "X";
                    } else {
                        field[rowOfY][columnOfY + 1] = "-";
                    }
                    commandsList.add(command);
                }
            }
            if (field[rowOfY][columnOfY].equals("X")) {
                field[rowOfY][columnOfY] = "X/Y";
            } else {
                field[rowOfY][columnOfY] = "Y";
            }
            command = scanner.nextLine();
        }

        if(field[rowOfY][columnOfY].equals("X/Y")) {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + String.join(", ", commandsList));
        } else {
            System.out.println("The map is fake!");
        }

    }

    private static boolean isTree(int rowOfY, int columnOfY, String[][] field) {
        if (field[rowOfY][columnOfY].equals("T")) {
            return true;
        }
        return false;
    }

    private static boolean isOutOfField(int rowOfY, int colOfY, int rows, int cols) {
        if(rowOfY < 0 || colOfY < 0 || rowOfY >= rows || colOfY >= cols) {
            return true;
        }
        return false;
    }
}
