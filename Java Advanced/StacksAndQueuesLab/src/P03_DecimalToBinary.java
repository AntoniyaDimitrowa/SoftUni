import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P03_DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();

        if(num == 0) {
            System.out.println(0);
        } else {
            while(num != 0) {
                stack.push(num % 2);
                num /= 2;
            }
            while(!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
    }
}
