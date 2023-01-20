import java.util.ArrayDeque;
import java.util.Scanner;

public class P05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> stackOfOpenParenthesis = new ArrayDeque<>();

        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') {
                stackOfOpenParenthesis.push(input.charAt(i));
            } else if (input.charAt(i) == ')') {
                if(!stackOfOpenParenthesis.isEmpty() && stackOfOpenParenthesis.peek() == '(') {
                    stackOfOpenParenthesis.pop();
                } else {
                    System.out.println("NO");
                    return;
                }
            } else if (input.charAt(i) == ']') {
                if(!stackOfOpenParenthesis.isEmpty() && stackOfOpenParenthesis.peek() == '[') {
                    stackOfOpenParenthesis.pop();
                } else {
                    System.out.println("NO");
                    return;
                }
            } else if (input.charAt(i) == '}') {
                if(!stackOfOpenParenthesis.isEmpty() && stackOfOpenParenthesis.peek() == '{') {
                    stackOfOpenParenthesis.pop();
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if(stackOfOpenParenthesis.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
