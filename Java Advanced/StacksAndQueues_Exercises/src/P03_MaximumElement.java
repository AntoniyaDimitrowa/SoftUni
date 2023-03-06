import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            if(command[0].equals("1")) {
                int num = Integer.parseInt(command[1]);
                stack.push(num);
            } else if(command[0].equals("2")) {
                stack.pop();
            } else if(command[0].equals("3")) {
                if(!stack.isEmpty()) {
                    System.out.println(Collections.max(stack));
                }
            }
        }
    }
}
