import java.lang.reflect.Array;
import java.util.*;
import java.util.function.DoubleFunction;
import java.util.stream.Collectors;

public class P02_WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, ArrayList<String>> words = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            ArrayList<String> synonyms = new ArrayList<>();
            if(!words.containsKey(word)) {
                synonyms.add(synonym);
                words.put(word, synonyms);
            } else {
                words.get(word).add(synonym);
            }
        }

        for(Map.Entry<String, ArrayList<String>> entry : words.entrySet()) {
            System.out.printf("%s - ", entry.getKey());
            for(int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("%s", entry.getValue().get(i));
                if(i < entry.getValue().size() - 1) {
                    System.out.print(", ");
                }
            }
        }
    }
}
