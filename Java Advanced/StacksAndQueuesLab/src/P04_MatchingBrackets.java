import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Deque<Integer> indexes = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(') {
                indexes.push(i);
            } else if(input.charAt(i) == ')') {
                int startIndex = indexes.pop();
                String subExpression = input.substring(startIndex, i + 1);
                System.out.println(subExpression);
            }
        }
    }
}
