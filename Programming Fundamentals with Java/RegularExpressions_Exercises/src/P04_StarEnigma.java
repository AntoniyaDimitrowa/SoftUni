import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04_StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfMessages = Integer.parseInt(scanner.nextLine());
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        String regex = "[^@:!>-]*?@(?<planetName>[A-Za-z]+)[^@:!>-]*?\\:(?<planetPopulation>\\d+)[^@:!>-]*?\\!(?<attackType>[AD])\\![^@:!>-]*?\\-\\>(?<soldierCount>\\d+)[^@:!>-]*";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < numberOfMessages; i++) {
            String message = scanner.nextLine();
            String decryptedMessage = decryptMessage(message).toString();
            Matcher matcher = pattern.matcher(decryptedMessage);

            if(matcher.find()) {
                String planetName = matcher.group("planetName");
                String attackType = matcher.group("attackType");

                if(attackType.equals("A")) {
                    attackedPlanets.add(planetName);
                } else if(attackType.equals("D")) {
                    destroyedPlanets.add(planetName);
                }
            }
        }

        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);

        System.out.println("Attacked planets: " + attackedPlanets.size());
        for (int i = 0; i < attackedPlanets.size(); i++) {
            System.out.println("-> " + attackedPlanets.get(i));
        }

        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        for (int i = 0; i < destroyedPlanets.size(); i++) {
            System.out.println("-> " + destroyedPlanets.get(i));
        }
    }

    static StringBuilder decryptMessage(String string) {
        StringBuilder sb = new StringBuilder();
        int contSTAR = 0;
        for (int i = 0; i < string.length(); i++) {
            if(string.toLowerCase().charAt(i) == 'a' || string.toLowerCase().charAt(i) == 's' || string.toLowerCase().charAt(i) == 't' || string.toLowerCase().charAt(i) == 'r') {
                contSTAR++;
            }
        }

        for (int i = 0; i < string.length(); i++) {
            int currCharASCII = string.charAt(i);
            int newCharASCII = currCharASCII - contSTAR;
            char newChar = (char) newCharASCII;
            sb.append(newChar);
        }

        return sb;
    }
}
