import java.util.Scanner;

public class P05Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String destination = "";

        while(!command.equals("End")) {
            destination = command;
            double minBudget = Double.parseDouble(scanner.nextLine());
            double savings = 0.0;
            while(savings<minBudget)
            {
                double currSavings = Double.parseDouble(scanner.nextLine());
                savings += currSavings;
            }
            System.out.printf("Going to %s!%n", destination);
            command = scanner.nextLine();
        }
    }
}
