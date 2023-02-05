import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<int[], Integer> findMin = elem -> Arrays.stream(elem).min().getAsInt();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(elem -> Integer.parseInt(elem))
                .toArray();

        int min = findMin.apply(numbers);
        System.out.println(min);
    }
}
