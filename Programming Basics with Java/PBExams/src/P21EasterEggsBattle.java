import java.util.Scanner;

public class P21EasterEggsBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int eggs1Count = Integer.parseInt(scanner.nextLine());
        int eggs2Count = Integer.parseInt(scanner.nextLine());
        int points1 = 0;
        int points2 = 0;
        String winner = scanner.nextLine();

        while (!winner.equals("End"))
        {
            if (winner.equals("one"))
            {
                eggs2Count--;
            }
            else if (winner.equals("two"))
            {
                eggs1Count--;
            }

            if (eggs1Count == 0)
            {
                System.out.printf("Player one is out of eggs. Player two has %d eggs left.", eggs2Count);
                break;
            }
            else if (eggs2Count == 0)
            {
                System.out.printf("Player two is out of eggs. Player one has %d eggs left.", eggs1Count);
                break;
            }

            winner = scanner.nextLine();
        }

        if (winner.equals("End"))
        {
            System.out.printf("Player one has %d eggs left.%n", eggs1Count);
            System.out.printf("Player two has %d eggs left.", eggs2Count);
        }
    }
}
