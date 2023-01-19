import java.util.ArrayDeque;
import java.util.Scanner;

public class P08_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ArrayDeque<String> browser = new ArrayDeque<>();
        ArrayDeque<String> forwardPages = new ArrayDeque<>();

        while(!command.equals("Home")) {
            if(command.equals("back")) {
                if(browser.size() >= 2) {
                    forwardPages.addFirst(browser.pop());
                    System.out.println(browser.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if(command.equals("forward")){
                if(forwardPages.size() < 1) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwardPages.peek());
                    browser.push(forwardPages.pop());
                }
            } else {
                System.out.println(command);
                browser.push(command);
                forwardPages.clear();
            }
            command = scanner.nextLine();
        }
    }
}
