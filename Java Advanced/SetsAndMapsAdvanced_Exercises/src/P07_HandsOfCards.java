import java.util.*;

public class P07_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> playersDecks = new LinkedHashMap<>();
        Map<String, Integer> charPower = getPowers();

        String command = scanner.nextLine();
        while (!command.equals("JOKER")) {
            String[] commandArr = command.split(": ");
            String name = commandArr[0];
            String[] currCards = commandArr[1].split(", ");

            if(playersDecks.containsKey(name)) {
                Set<String> deck = playersDecks.get(name);
                deck.addAll(List.of(currCards));
                playersDecks.put(name, deck);
            } else {
                Set<String> deck = new HashSet<>();
                deck.addAll(List.of(currCards));
                playersDecks.put(name, deck);
            }
            command = scanner.nextLine();
        }
        for (Map.Entry<String, Set<String>> entry : playersDecks.entrySet()) {
            String name = entry.getKey();
            Set<String> deck = entry.getValue();
            int value = 0;
            for (String element : deck) {
                if(element.length() == 2) {
                    int power = charPower.get(element.charAt(0) + "");
                    int type = charPower.get(element.charAt(1) + "");
                    value = value + (power * type);
                } else {
                    int power = 10;
                    int type = charPower.get(element.charAt(2) + "");
                    value = value + (power * type);
                }
            }
            System.out.println(name + ": " + value);
        }
    }
    public static Map<String, Integer> getPowers() {
        Map<String, Integer> result = new HashMap<>();
        int n = 2;
        for (char i = '2'; i <= '9'; i++) {
            result.put((i + ""), n);
            n++;
        }
        result.put("10", 10);
        result.put("J", 11);
        result.put("Q", 12);
        result.put("K", 13);
        result.put("A", 14);
        result.put("S", 4);
        result.put("H", 3);
        result.put("D", 2);
        result.put("C", 1);
        return result;
    }
}
