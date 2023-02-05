import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<List<Integer>, Integer> findSmallest = list -> list.stream().min((a, b) -> Integer.compare(a, b)).get();

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());

        int minNum = findSmallest.apply(numbers);
        int index = numbers.lastIndexOf(minNum);
        System.out.println(index);
    }
}
