import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P08_InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        StringBuilder output = new StringBuilder();
        ArrayDeque<String> operators = new ArrayDeque<>();

        Pattern patternLetters = Pattern.compile("[a-z]+");
        Pattern patternDigits = Pattern.compile("[0-9]+");
        Pattern patternOperators = Pattern.compile("[\\+\\-\\*\\/\\(\\)]");

        for (int i = 0; i < input.length; i++) {
            String current = input[i];
            Matcher matcherLetters = patternLetters.matcher(current);
            Matcher matcherDigits = patternDigits.matcher(current);
            Matcher matcherOperators = patternOperators.matcher(current);
            if(matcherLetters.find() || matcherDigits.find()) {
                output.append(current);
                output.append(" ");
            } else if(matcherOperators.find()) {
                if(operators.isEmpty()) {
                    operators.push(current);
                } else {
                    if(current.equals("(")) {
                        operators.push(current);
                    } else if(current.equals("+") || current.equals("-")) {
                        if(operators.peek().equals("+") || operators.peek().equals("-")) {
                            output.append(operators.pop());
                            output.append(" ");
                        }
                        operators.push(current);
                    } else if(current.equals("*") || current.equals("/")) {
                        if(operators.peek().equals("*") || operators.peek().equals("/")) {
                            output.append(operators.pop());
                            output.append(" ");
                        }
                        operators.push(current);
                    } else if (current.equals(")")) {
                        while (!operators.peek().equals("(")) {
                            output.append(operators.pop());
                            output.append(" ");
                        }
                        operators.pop();
                    }
                }
            }
        }
        while (!operators.isEmpty()) {
            output.append(operators.pop());
            output.append(" ");
        }
        System.out.println(output);
    }
}
