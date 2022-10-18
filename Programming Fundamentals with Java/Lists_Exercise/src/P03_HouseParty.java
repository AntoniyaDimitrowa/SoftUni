import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P03_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandsCount = Integer.parseInt(scanner.nextLine());
        List<String> guestsNames = new ArrayList<>();
        for (int i = 0; i < commandsCount; i++) {
            String[] command = scanner.nextLine().split(" ");
            String guestName = command[0];
            if (command[2].equals("not")) {
                if(guestsNames.contains(guestName)) {
                    guestsNames.remove(guestName);
                } else {
                    System.out.printf("%s is not in the list!%n", guestName);
                }
            } else {
                if(guestsNames.size() == 0) {
                    guestsNames.add(guestName);
                } else {
                    if(guestsNames.contains(guestName)) {
                        System.out.printf("%s is already in the list!%n", guestName);

                    } else {
                        guestsNames.add(guestName);
                    }
                }
            }
        }
        for (int i = 0; i < guestsNames.size(); i++) {
            System.out.println(guestsNames.get(i));
        }
    }
}
