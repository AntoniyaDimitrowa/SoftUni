import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class P09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int upperBond = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = generateList(upperBond);
        List<Integer> dividers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BiFunction<Integer, List<Integer>, Boolean> isDivisible = (num, list) -> {
            for (int divider : list) {
                if(num % divider != 0) {
                    return false;
                }
            }
            return true;
        };

        numbers.stream()
                .filter(num -> isDivisible.apply(num, dividers))
                .forEach(num -> System.out.print(num + " "));
    }

    private static List<Integer> generateList(int upperBond) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= upperBond; i++) {
            list.add(i);
        }
        return list;
    }
}
