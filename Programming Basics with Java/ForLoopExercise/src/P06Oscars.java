import java.util.Scanner;

public class P06Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String actorName = scanner.nextLine();
        double pointsFromTheAcademy = Double.parseDouble(scanner.nextLine());
        int numberOfEvaluators = Integer.parseInt(scanner.nextLine());
        double totalPoints = pointsFromTheAcademy;
        for(int i = 1; i <= numberOfEvaluators; i++)
        {
            String evaluatorName = scanner.nextLine();
            double pointsFromEvaluator = Double.parseDouble(scanner.nextLine());
            double totalPointsFromEvaluator = (evaluatorName.length() * pointsFromEvaluator)/2;
            totalPoints = totalPoints + totalPointsFromEvaluator;
            if(totalPoints > 1250.5)
            {
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, totalPoints);
                break;
            }
        }
        if (totalPoints < 1250.5)
        {
            System.out.printf("Sorry, %s you need %.1f more!", actorName, 1250.5 - totalPoints);
        }
    }
}
