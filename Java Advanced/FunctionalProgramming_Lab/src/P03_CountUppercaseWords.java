import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //first way
        /*
        String[] words = scanner.nextLine().split("\\s+");
        List<String> uppercaseWords = new ArrayList<>();
        Pattern pattern = Pattern.compile("[A-Z]+[a-z]*");
        for (int i = 0; i < words.length; i++) {
            Matcher matcher = pattern.matcher(words[i]);
            if(matcher.find()) {
                uppercaseWords.add(words[i]);
            }
        }
        System.out.println(uppercaseWords.size());
        uppercaseWords.forEach(e -> System.out.println(e));
        */

        //second way
        Predicate<String> startsWithUppercase = word -> Character.isUpperCase(word.charAt(0));
        Consumer<String> print = s -> System.out.println(s);

        List<String> uppercaseWords = Arrays.stream(scanner.nextLine().split(" "))
                .filter(w -> startsWithUppercase.test(w))
                .collect(Collectors.toList());

        System.out.println(uppercaseWords.size());

        uppercaseWords.forEach(elem -> print.accept(elem));
    }
}
