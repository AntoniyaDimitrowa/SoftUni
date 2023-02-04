import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        numbers.removeIf(num -> num % 2 != 0);
        //numbers.stream().filter(num -> num % 2 == 0);

        if(!numbers.isEmpty()) {
            String evenNumbers = numbers.stream()
                    .map(e -> String.valueOf(e))
                    .collect(Collectors.joining(", "));
            System.out.println(evenNumbers);

            String sorted = numbers.stream()
                    .sorted()
                    .map(e -> String.valueOf(e))
                    .collect(Collectors.joining(", "));

            System.out.println(sorted);
        }
    }
}
