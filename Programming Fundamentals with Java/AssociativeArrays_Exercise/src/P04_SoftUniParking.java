import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04_SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, String> users = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] commandArr = scanner.nextLine().split("\\s+");
            String currCommand = commandArr[0];
            String username = commandArr[1];

            switch (currCommand) {
                case "register":
                    String licensePlateNumber = commandArr[2];
                    if(users.containsKey(username)) {
                        System.out.println("ERROR: already registered with plate number " + licensePlateNumber);
                    } else {
                        users.put(username, licensePlateNumber);
                        System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
                    }
                    break;
                case "unregister":
                    if(users.containsKey(username)) {
                        users.remove(username);
                        System.out.println(username + " unregistered successfully");
                    } else {
                        System.out.printf("ERROR: user %s not found%n", username);
                    }
                    break;
            }
        }

        for (Map.Entry<String,String> entry : users.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
