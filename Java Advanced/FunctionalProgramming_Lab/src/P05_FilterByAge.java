import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P05_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] array = scanner.nextLine().split(", ");
            String name = array[0];
            int age = Integer.parseInt(array[1]);
            people.put(name, age);
        }

        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> filter = getPredicate(condition, ageLimit);
        Consumer<Map.Entry<String, Integer>> print = getPrintConsumer(format);

        people.entrySet().stream()
                .filter(entry -> filter.test(entry.getValue()))
                .forEach(entry -> print.accept(entry));
    }

    private static Consumer<Map.Entry<String, Integer>> getPrintConsumer(String format) {
        switch (format) {
            case "name":
                return e -> System.out.println(e.getKey());
            case "age":
                return e -> System.out.println(e.getValue());
            case "name age":
                return e -> System.out.println(e.getKey() + " - " + e.getValue());
            default: throw new RuntimeException("Bad format! Use 'name', 'age' or 'name age'");
        }
    }

    private static Predicate<Integer> getPredicate(String condition, int ageLimit) {
        if(condition.equals("older")) {
            return x -> x >= ageLimit;
        } else if(condition.equals("younger")) {
            return x -> x <= ageLimit;
        } else {
            throw new RuntimeException("Bad condition! Use 'older' or 'younger'");
        }
    }
}
