import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class P02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> print = s -> System.out.println(s);
        Function<String, String> addSir = elem -> "Sir " + elem;
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(elem -> addSir.apply(elem))
                .forEach(elem -> print.accept(elem));
    }
}
