import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01_CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        LinkedHashMap<Character, Integer> counts = new LinkedHashMap<>();
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == ' ') {
                continue;
            }
            if(!counts.containsKey(string.charAt(i))) {
                counts.put(string.charAt(i), 1);
            } else {
                counts.put(string.charAt(i), counts.get(string.charAt(i)) + 1);
            }
        }

        for (Map.Entry<Character, Integer> item : counts.entrySet()) {
            System.out.println(item.getKey() + " -> " + item.getValue());
        }
    }
}
