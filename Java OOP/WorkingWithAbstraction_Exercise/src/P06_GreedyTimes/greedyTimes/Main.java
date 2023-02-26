package P06_GreedyTimes.greedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacity);

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long quantity = Long.parseLong(safe[i + 1]);

            String type = whatTypeIsIt(name);

            if (type == null || !bag.canAdd(type, quantity)) {
                continue;
            }
            bag.add(type, name, quantity);
        }

        System.out.println(bag);
    }

    private static String whatTypeIsIt(String name) {
        if (name.length() == 3) {
            return  "Cash";
        } else if (name.toLowerCase().endsWith("gem") && name.length() > 3) {
            return  "Gem";
        } else if (name.toLowerCase().equals("gold")) {
            return  "Gold";
        }
        return null;
    }
}