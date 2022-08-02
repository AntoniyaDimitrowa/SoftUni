import java.util.Scanner;

public class P02ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfBadGrades = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int badGradesCounter = 0;
        int allGradesCounter = 0;
        String name = "";
        String command = scanner.nextLine();

        while(!command.equals("Enough")) {
            name = command;
            int grade = Integer.parseInt(scanner.nextLine());
            allGradesCounter++;
            sum += grade;
            if(grade <= 4) {
                badGradesCounter++;
                if(badGradesCounter >= numberOfBadGrades) {
                    System.out.printf("You need a break, %d poor grades.", badGradesCounter);
                    break;
                }
            }
            command = scanner.nextLine();
        }

        if(command.equals("Enough")) {
            System.out.printf("Average score: %.2f%n", sum * 1.0 / allGradesCounter);
            System.out.printf("Number of problems: %d%n", allGradesCounter);
            System.out.printf("Last problem: %s%n", name);
        }
    }
}
