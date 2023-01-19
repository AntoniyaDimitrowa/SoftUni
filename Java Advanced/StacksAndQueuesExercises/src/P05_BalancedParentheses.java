import java.util.ArrayDeque;
import java.util.Scanner;

public class P05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> stackOfOpenParenthesis = new ArrayDeque<>();
        ArrayDeque<Character> stackOfClosingParenthesis = new ArrayDeque<>();

        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') {
                stackOfOpenParenthesis.push(input.charAt(i));
            } else if (input.charAt(i) == ')') {
                if(stackOfOpenParenthesis.peek() == '(') {
                    stackOfOpenParenthesis.pop();
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
