import java.util.Scanner;

public class P04Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int steps = 10000;
        int stepsForTheDay = 0;
        String command;

        while(true)
        {
            command = scanner.nextLine();
            if(command.equals("Going home"))
            {
                int stepsFromWalkingHome = Integer.parseInt(scanner.nextLine());
                stepsForTheDay += stepsFromWalkingHome;
                if (steps > stepsForTheDay)
                {
                    System.out.printf("%d more steps to reach goal.", Math.abs(steps - stepsForTheDay));
                    break;
                }
            }
            else
            {
                int currSteps = Integer.parseInt(command);
                stepsForTheDay += currSteps;
            }
            if (steps <= stepsForTheDay)
            {
                System.out.println("Goal reached! Good job!");
                System.out.printf("%d steps over the goal!", Math.abs(steps - stepsForTheDay));
                break;
            }
        }
    }
}
