import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05_AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int totalCalories = 0;
        String regex = "([#|\\|])(?<item>[A-Za-z\\s]+)\\1(?<expirationDate>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        StringBuilder outputItems = new StringBuilder();
        while (matcher.find()) {
            String item = matcher.group("item");
            String expirationDate = matcher.group("expirationDate");
            int calories = Integer.parseInt(matcher.group("calories"));

            outputItems.append(String.format("Item: %s, Best before: %s, Nutrition: %d%n", item, expirationDate, calories));
            totalCalories += calories;
        }

        int daysLeft = (int) Math.floor(totalCalories / 2000.0);
        System.out.println("You have food to last you for: " + daysLeft + " days!");
        System.out.println(outputItems);
    }
}
