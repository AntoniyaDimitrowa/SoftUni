import java.util.ArrayDeque;
import java.util.Scanner;

public class P08_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ArrayDeque<String> browser = new ArrayDeque<>();
        ArrayDeque<String> forwardPages = new ArrayDeque<>();
        String current = "";

        while(!command.equals("Home")) {
            if(command.equals("back")) {
                if(!browser.isEmpty()) {
                    forwardPages.addFirst(browser.pop());
                    current = browser.peek();
                } else {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }
            } else if(command.equals("forward")){
                if(forwardPages.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    browser.push(forwardPages.peek());
                    forwardPages.clear();
                    current = browser.peek();
                }
            } else {
                current = command;
            }
            System.out.println(current);
            command = scanner.nextLine();
        }
    }
}
