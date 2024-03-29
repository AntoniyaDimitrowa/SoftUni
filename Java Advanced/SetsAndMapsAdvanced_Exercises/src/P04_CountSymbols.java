import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> characters = new TreeMap<>();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char currCharacter = input.charAt(i);
            if(characters.containsKey(currCharacter)) {
                int count = characters.get(currCharacter);
                count++;
                characters.put(currCharacter, count);
            } else {
                characters.put(currCharacter, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : characters.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
