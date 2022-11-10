import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04_WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        String[] evenWords = Arrays.stream(words).filter(w -> w.length() % 2 == 0).toArray(String[] :: new);

        for (String item:evenWords) {
            System.out.println(item);
        }

    }
}
