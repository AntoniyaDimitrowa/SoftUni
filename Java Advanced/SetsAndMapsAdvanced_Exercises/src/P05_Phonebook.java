import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> people = new TreeMap<>();
        String command = scanner.nextLine();
        while (!command.equals("search")) {
            String name = command.split("-")[0];
            String phoneNumber = command.split("-")[1];
            if(people.containsKey(name)) {
                people.put(name, phoneNumber);
            } else {
                people.put(name, phoneNumber);
            }
            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        while (!command.equals("stop")) {
            String name = command;
            if(people.containsKey(name)) {
                System.out.println(name + " -> " + people.get(name));
            } else {
                System.out.println("Contact " + name + " does not exist.");
            }
            command = scanner.nextLine();
        }
    }
}
