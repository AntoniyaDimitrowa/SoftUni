import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> usernames = new LinkedHashSet<>();
        int numberOfUsernames = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfUsernames; i++) {
            String username = scanner.nextLine();
            usernames.add(username);
        }
        usernames.forEach(user -> System.out.println(user));
    }
}
