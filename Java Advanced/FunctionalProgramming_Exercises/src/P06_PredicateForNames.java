import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxLength = Integer.parseInt(scanner.nextLine());

        Predicate<String> filterCondition = name -> name.length() <= maxLength;
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(name -> filterCondition.test(name))
                .collect(Collectors.toList());

        names.forEach(name -> System.out.println(name));
    }
}
