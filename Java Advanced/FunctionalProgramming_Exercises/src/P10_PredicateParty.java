import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("Party!")) {
            String[] commandArr = command.split("\\s+");
            String removeOrDouble = commandArr[0];
            String type = commandArr[1];
            String parameter = commandArr[2];

            if (removeOrDouble.equals("Remove")) {
                guests.removeIf(predicates(type, parameter));
            } else if (removeOrDouble.equals("Double")) {
                for (int i = 0; i < guests.size(); i++) {
                    if (predicates(type, parameter).test(guests.get(i))) {
                        guests.add(i, guests.get(i));
                    }
                    i++;
                }
            }

            command = scanner.nextLine();
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guests);
            System.out.printf("%s are going to the party!%n", String.join(", ", guests));
        }
    }

    public static Predicate<String> predicates(String type, String param) {
        if (type.equals("StartsWith")) {
            return str -> str.startsWith(param);
        } else if (type.equals("EndsWith")) {
            return str -> str.endsWith(param);
        } else if (type.equals("Length")) {
            return str -> str.length() == Integer.parseInt(param);
        } else {
            return str -> false;
        }
    }
}
