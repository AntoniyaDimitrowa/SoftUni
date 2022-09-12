import java.util.Scanner;

public class P20CatWalking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minutesWalkingPerWalk = Integer.parseInt(scanner.nextLine());
        int walksCountPerDay = Integer.parseInt(scanner.nextLine());
        int caloriesPerDay = Integer.parseInt(scanner.nextLine());
        int minutesWalkingPerDay = walksCountPerDay * minutesWalkingPerWalk;
        int burnedCalories = minutesWalkingPerDay * 5;
        double halfOfCalories = 0.5 * caloriesPerDay;

        if(burnedCalories < halfOfCalories) {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", burnedCalories);
        } else {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", burnedCalories);
        }
    }
}
