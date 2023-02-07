package P01_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person currPerson = new Person(name, age);
            people.add(currPerson);
        }

        Predicate<Integer> filterCondition = integer -> integer > 30;
        Comparator<Person> sort = (p1, p2) -> p1.getName().compareTo(p2.getName());
        people.stream()
                .sorted(sort)
                .filter(p -> filterCondition.test(p.getAge()))
                .forEach(p -> System.out.printf("%s - %d%n", p.getName(), p.getAge()));
    }
}
