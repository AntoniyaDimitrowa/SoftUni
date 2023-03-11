package P04_FoodShortage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPeople = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> buyers = new LinkedHashMap<>();

        for (int i = 0; i < numPeople; i++) {
            String[] command = scanner.nextLine().split("\\s+");

            switch (command.length) {
                case 4:
                    Citizen citizen = new Citizen(command[0], Integer.parseInt(command[1]), command[2], command[3]);
                    buyers.put(citizen.getName(), citizen);
                    break;
                case 3:
                    Rebel rebel = new Rebel(command[0], Integer.parseInt(command[1]), command[2]);
                    buyers.put(rebel.getName(), rebel);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown input!");
            }
        }

        FoodShortageCommandHandler handler = new FoodShortageCommandHandler(buyers, "End");
        handler.readAndHandleCommandsToEnd(scanner);

        int sum = buyers.values()
                .stream()
                .mapToInt(b -> b.getFood())
                .sum();

        System.out.println(sum);
    }
}
