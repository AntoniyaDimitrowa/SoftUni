import java.util.*;

public class P03_OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();

        for (String word : words) {
            String wordInLowerCase = word.toLowerCase();
            if(!counts.containsKey(wordInLowerCase)) {
                counts.put(wordInLowerCase, 1);
            } else {
                counts.put(wordInLowerCase, counts.get(wordInLowerCase) +1);
            }
        }

        List<String> odds = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                odds.add(entry.getKey());
            }
        }

        for (int i = 0; i < odds.size(); i++) {
            System.out.print(odds.get(i));
            if(i < odds.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
