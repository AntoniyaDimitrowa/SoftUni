import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");

        Random rnd = new Random();
        for (int i = 0; i < words.length; i++) {
            int indexX = rnd.nextInt(words.length);
            int indexY = rnd.nextInt(words.length);

            String oldWord = words[indexX];
            words[indexX] = words[indexY];
            words[indexY] = oldWord;
        }
        System.out.println(String.join(System.lineSeparator(), words));
    }
}
