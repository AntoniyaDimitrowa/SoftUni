import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> users = new TreeMap<>();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commandArr = command.split(" ");
            String ip = commandArr[0].substring(3);
            String user = commandArr[2].substring(5);
            if(users.containsKey(user)) {
                Map<String, Integer> ips = users.get(user);
                if(ips.containsKey(ip)) {
                    int count = ips.get(ip);
                    count++;
                    ips.put(ip, count);
                    users.put(user, ips);
                } else {
                    ips.put(ip, 1);
                    users.put(user, ips);
                }
            } else {
                Map<String, Integer> ips = new LinkedHashMap<>();
                ips.put(ip, 1);
                users.put(user, ips);
            }
            command = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Integer>> entry : users.entrySet()) {
            System.out.println(entry.getKey() + ": ");
            Map<String, Integer> ips = entry.getValue();
            int count = ips.size();
            for (Map.Entry<String, Integer> entry2 : ips.entrySet()) {
                if(count <= 1) {
                    System.out.printf("%s => %d.%n", entry2.getKey(), entry2.getValue());
                } else {
                    System.out.printf("%s => %d, ", entry2.getKey(), entry2.getValue());
                }
                count--;
            }
        }
    }
}
