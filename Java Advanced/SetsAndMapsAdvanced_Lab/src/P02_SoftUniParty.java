import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> guests = new TreeSet<>();
        String command = scanner.nextLine();
        while(!command.equals("PARTY")) {
            guests.add(command);
            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        while(!command.equals("END")) {
            guests.remove(command);
            command = scanner.nextLine();
        }
        System.out.println(guests.size());
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
