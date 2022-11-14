import java.util.Scanner;

public class P02_RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                result.append(word);
            }
        }

        System.out.println(result);
    }
}
