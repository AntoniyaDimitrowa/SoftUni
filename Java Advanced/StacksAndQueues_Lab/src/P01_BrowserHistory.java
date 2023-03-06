import java.util.ArrayDeque;
import java.util.Scanner;

public class P01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ArrayDeque<String> browser = new ArrayDeque<>();
        String current = "";

        while(!command.equals("Home")) {
            if(command.equals("back")) {
                if(!browser.isEmpty()) {
                    current = browser.pop();
                } else {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }
            } else {
                if(!current.equals("")) {
                    browser.push(current);
                }
                current = command;
            }
            System.out.println(current);
            command = scanner.nextLine();
        }
    }
}
