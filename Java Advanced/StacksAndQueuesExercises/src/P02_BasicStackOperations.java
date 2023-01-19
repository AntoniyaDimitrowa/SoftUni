import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int s = input[1];
        int x = input[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(scanner.next()));
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if(stack.contains(x)) {
            System.out.println("true");
        } else {
            if (stack.isEmpty()) {
                System.out.println(0);
            } else {
                int min = getMin(stack);
                System.out.println(min);
            }
        }
    }
    public  static int getMin(ArrayDeque<Integer> stack) {
        int min = stack.pop();
        while(!stack.isEmpty()) {
            if(min > stack.peek()) {
                min = stack.pop();
            } else {
                stack.pop();
            }
        }
        return min;
    }
}
