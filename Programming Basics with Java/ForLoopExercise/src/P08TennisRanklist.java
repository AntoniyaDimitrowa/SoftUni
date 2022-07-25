import java.util.Scanner;

public class P08TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tournamentsCount = Integer.parseInt(scanner.nextLine());
        int pointsInTheBegining = Integer.parseInt(scanner.nextLine());
        int totalPoints = pointsInTheBegining;
        int numberOfWins = 0;

        for(int i = 1; i <= tournamentsCount; i++) {
            String tournamentStage = scanner.nextLine();
            if(tournamentStage.equals("W"))
            {
                totalPoints = totalPoints + 2000;
                numberOfWins++;
            }
            if (tournamentStage.equals("F"))
            {
                totalPoints = totalPoints + 1200;
            }
            if (tournamentStage.equals("SF"))
            {
                totalPoints = totalPoints + 720;
            }
        }
        double averagePoints = (totalPoints - pointsInTheBegining) / (tournamentsCount*1.0);
        double average = Math.floor(averagePoints);

        System.out.printf("Final points: %d%n", totalPoints);
        System.out.printf("Average points: %.0f%n", average);
        System.out.printf("%.2f%%%n", ((numberOfWins*1.0)/tournamentsCount)*100);
    }
}
