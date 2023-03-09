package P04_FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        List<Buyer> buyers = new ArrayList<>();

        for (int i = 0; i < numberOfLines; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            Buyer b;
            switch (command.length) {
                case 4:
                    b = new Citizen(command[0], Integer.parseInt(command[1]), command[2], command[3]);
                    break;
                case 3:
                    b = new Rebel(command[0], Integer.parseInt(command[1]), command[2]);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown command: " + command[0]);
            }
            buyers.add(b);
        }

        FoodShortageCommandHandler handler = new FoodShortageCommandHandler("End");
        handler.readAndHandleCommandsToEnd(scanner);

        System.out.println(handler.getFinalResult());
    }
}
