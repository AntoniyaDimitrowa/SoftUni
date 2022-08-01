import java.util.Scanner;

public class P08Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int currClass = 1;
        double totalGrades = 0;
        int repeatCounter = 0;

        while(currClass <= 12) {
            double grade = Double.parseDouble(scanner.nextLine());
            totalGrades = totalGrades + grade;
            if(grade < 4.00) {
                repeatCounter++;
                if(repeatCounter > 1) {
                    break;
                }
                continue;
            }
            currClass++;
        }

        if (repeatCounter > 1)
        {
            System.out.printf("%s has been excluded at %d grade", name, currClass);
        }
        else
        {
            double averageGrades = totalGrades/(currClass-1 + repeatCounter);
            System.out.printf("%s graduated. Average grade: %.2f", name, averageGrades);
        }
    }
}
