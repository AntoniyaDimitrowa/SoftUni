import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class P05_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> queue = new ArrayDeque<>();
        String command = scanner.nextLine();
        while(!command.equals("print")) {
            if(command.equals("cancel")) {
                if(queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queue.poll());
                }
            } else {
                queue.add(command);
            }
            command = scanner.nextLine();
        }

        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
