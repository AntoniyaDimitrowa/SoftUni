import java.util.Scanner;

public class P02BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingPoints = Integer.parseInt(scanner.nextLine());
        double bonusPoints = 0;

        if(startingPoints <= 100) {
            bonusPoints = bonusPoints + 5;
        } else if (startingPoints > 1000) {
            bonusPoints = 0.10 * startingPoints;
        } else {
            bonusPoints = 0.20 * startingPoints;
        }

        if(startingPoints % 2 == 0) {
            bonusPoints = bonusPoints + 1;
        } else if(startingPoints % 10 == 5) {
            bonusPoints = bonusPoints + 2;
        }

        double totalPoints = startingPoints + bonusPoints;
        System.out.println(bonusPoints);
        System.out.println(totalPoints);
    }
}
