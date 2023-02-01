import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class P10_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLogs = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeSet<String>> usersIPs = new TreeMap<>();
        TreeMap<String, Integer> usersDuration = new TreeMap<>();

        for (int i = 0; i < numberOfLogs; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String ip = info[0];
            String user = info[1];
            int duration = Integer.parseInt(info[2]);

            usersDuration.putIfAbsent(user, 0);
            usersDuration.put(user, usersDuration.get(user) + duration);

            usersIPs.putIfAbsent(user, new TreeSet<>());
            usersIPs.get(user).add(ip);
        }

        usersDuration.forEach((k, v) -> {
            System.out.printf("%s: %d [%s]%n", k, v, String.join(", ", usersIPs.get(k)));
        });
    }
}
