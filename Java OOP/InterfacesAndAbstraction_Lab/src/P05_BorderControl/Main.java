package P05_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> inhabitants = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandArr = command.split("\\s+");

            Identifiable next;
            if(commandArr.length == 2) {
                next = new Robot(commandArr[0], commandArr[1]);
            } else {
                next = new Citizen(commandArr[0], Integer.parseInt(commandArr[1]), commandArr[2]);
            }

            inhabitants.add(next);

            command = scanner.nextLine();
        }

        String badIdSuffix = scanner.nextLine();

        for (Identifiable curr: inhabitants) {
            if (curr.getId().endsWith(badIdSuffix)) {
                System.out.println(curr.getId());
            }
        }
    }
}
