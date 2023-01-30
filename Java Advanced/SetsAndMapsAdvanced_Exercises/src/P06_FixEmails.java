import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> people = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("stop")) {
            String name = command;
            String email = scanner.nextLine();
            int lastDot = email.lastIndexOf('.');
            String emailEnd = email.substring(lastDot+1);
            if(!(emailEnd.equals("uk") || emailEnd.equals("us") || emailEnd.equals("com"))) {
                people.put(name, email);
            }
            command = scanner.nextLine();
        }
        for (Map.Entry<String, String> entry : people.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
