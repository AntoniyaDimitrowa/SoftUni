import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Double> parse = s -> Double.parseDouble(s);
        UnaryOperator<Double> addVAT = d -> d * 1.2;
        Consumer<Double> print = num -> System.out.printf("%.2f%n", num);

        List<Double> prices = Arrays.stream(scanner.nextLine().split(", "))
                .map(el -> parse.apply(el))
                .map(price -> addVAT.apply(price))
                .collect(Collectors.toList());

        System.out.println("Prices with VAT:");
        prices.forEach(el -> print.accept(el));
    }
}
