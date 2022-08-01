import java.util.Scanner;

public class P05AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0.0;
        String command = scanner.nextLine();

        while (!command.equals("NoMoreMoney")) {
            double num = Double.parseDouble(command);
            if(num < 0) {
                System.out.println("Invalid operation!");
                break;
            }
            System.out.printf("Increase: %.2f%n", num);
            sum = sum + num;
            command = scanner.nextLine();
        }

        System.out.printf("Total: %.2f", sum);
    }
}
