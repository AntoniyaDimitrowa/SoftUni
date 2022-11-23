import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05_NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] demonsNames = scanner.nextLine().split("\\s*,\\s*");

        String healthRegex = "[^\\+\\-\\*\\/\\.\\d]";
        Pattern healthPattern = Pattern.compile(healthRegex);
        String damageRegex = "\\-?[0-9]+\\.?[0-9]*";
        Pattern damagePattern = Pattern.compile(damageRegex);

        for (int i = 0; i < demonsNames.length; i++) {
            String currDemon = demonsNames[i];
            if(currDemon.contains(",") || currDemon.contains(" ")) {
                continue;
            }
            int health = 0;
            double damage = 0.00;

            Matcher healthMatcher = healthPattern.matcher(currDemon);
            while (healthMatcher.find()) {
                int charASCII = healthMatcher.group().charAt(0);
                health += charASCII;
            }

            Matcher damageMatcher = damagePattern.matcher(currDemon);
            while (damageMatcher.find()) {
                double currCharacter = Double.parseDouble(damageMatcher.group());
                damage += currCharacter;
            }

            for (int j = 0; j < currDemon.length(); j++) {
                if(currDemon.charAt(j) == '*') {
                    damage *= 2;
                } else if(currDemon.charAt(j) == '/') {
                    damage /= 2;
                }
            }
            System.out.printf("%s - %d health, %.2f damage%n", currDemon, health, damage);
        }
    }
}
