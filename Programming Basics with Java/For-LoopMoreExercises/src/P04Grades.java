import java.util.Scanner;

public class P04Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        double sumOfAllGrades = 0.0;
        int topStudents = 0;
        int firstGroup = 0;
        int secondGroup = 0;
        int fails = 0;

        for(int i = 1; i <= students; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            sumOfAllGrades = sumOfAllGrades + grade;
            if(grade < 3) {
                fails++;
            } else if(grade < 4) {
                secondGroup++;
            } else if(grade < 5) {
                firstGroup++;
            } else {
                topStudents++;
            }
        }

        double topStudentsPercent = ((topStudents * 1.0) / students) * 100;
        double firstGroupPercent = ((firstGroup * 1.0) / students) * 100;
        double secondGroupPercent = ((secondGroup * 1.0) / students) * 100;
        double failsPercent = ((fails * 1.0) / students) * 100;

        double average = sumOfAllGrades / students;

        System.out.printf("Top students: %.2f%%%n", topStudentsPercent);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", firstGroupPercent);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", secondGroupPercent);
        System.out.printf("Fail: %.2f%%%n", failsPercent);
        System.out.printf("Average: %.2f%n", average);
    }
}
