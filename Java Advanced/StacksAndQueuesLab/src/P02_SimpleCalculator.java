import java.util.ArrayDeque;
import java.util.Scanner;

public class P02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = input.length - 1; i >= 0; i--) {
            stack.push(input[i]);
        }

        int result = Integer.parseInt(stack.pop());
        while(stack.size() != 0) {
            String operator = stack.pop();
            int currNum = Integer.parseInt(stack.pop());
            if(operator.equals("+")) {
                result += currNum;
            } else {
                result -= currNum;
            }
        }

        System.out.println(result);
    }
}
