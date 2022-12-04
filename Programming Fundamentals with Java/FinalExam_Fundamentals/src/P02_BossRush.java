import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_BossRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        String regex = "\\|(?<bossName>[A-Z]{4}[A-Z]*)\\|\\:\\#(?<bossTitle>[A-Za-z]+ [A-Za-z]+)\\#";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < numberOfInputs; i++) {
            String inputLine = scanner.nextLine();
            Matcher matcher = pattern.matcher(inputLine);
            if(matcher.find()) {
                String bossName = matcher.group("bossName");
                String bossTitle = matcher.group("bossTitle");
                int strength = bossName.length();
                int armor = bossTitle.length();
                System.out.printf("%s, The %s%n",bossName, bossTitle);
                System.out.printf(">> Strength: %d%n", strength);
                System.out.printf(">> Armor: %d%n", armor);
            } else {
                System.out.println("Access denied!");
            }
        }
    }
}
