import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Integer> parse = s -> Integer.parseInt(s);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(elem -> parse.apply(elem))
                .collect(Collectors.toList());

        int count = numbers.size();
        System.out.println("Count = " + count);

        int sum = numbers.stream()
                .mapToInt(a -> a)//identity function
                .sum();

        System.out.println("Sum = " + sum);
    }
}
