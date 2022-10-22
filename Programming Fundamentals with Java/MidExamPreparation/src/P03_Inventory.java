import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String[] commandArr = scanner.nextLine().split(" - ");

        while (!commandArr[0].equals("Craft!")) {
            if(commandArr[0].equals("Collect")) {
                String currItem = commandArr[1];
                if(!items.contains(currItem)) {
                    items.add(currItem);
                }
            } else if(commandArr[0].equals("Drop")) {
                String dropItem = commandArr[1];
                items.remove(dropItem);
            } else if(commandArr[0].equals("Combine Items")) {
                String[] currItems = commandArr[1].split(":");
                String oldItem = currItems[0];
                String newItem = currItems[1];
                if(items.contains(oldItem)) {
                    int oldItemIndex = items.indexOf(oldItem);
                    items.add(oldItemIndex+1, newItem);
                }

            } else if(commandArr[0].equals("Renew")) {
                String currItem = commandArr[1];
                if(items.contains(currItem)) {
                    items.remove(currItem);
                    items.add(currItem);
                }
            }
            commandArr = scanner.nextLine().split(" - ");
        }

        for (int i = 0; i < items.size() - 1; i++) {
            System.out.print(items.get(i) + ", ");
        }
        System.out.println(items.get(items.size() - 1));
    }
}
