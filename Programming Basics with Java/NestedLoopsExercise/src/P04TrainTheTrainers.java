import java.util.Scanner;

public class P04TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int juryMembers = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        double allGradesSum = 0.0;
        int presentationCounter = 0;

        while(!command.equals("Finish")) {
            String presentationName = command;
            presentationCounter++;
            double currGradesSum = 0;
            for(int i = 1; i <= juryMembers; i++) {
                double currGrade = Double.parseDouble(scanner.nextLine());
                currGradesSum += currGrade;
            }
            System.out.printf("%s - %.2f. %n", presentationName, (currGradesSum / juryMembers));
            allGradesSum += currGradesSum;
            command = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", allGradesSum / (juryMembers * presentationCounter));

    }
}
