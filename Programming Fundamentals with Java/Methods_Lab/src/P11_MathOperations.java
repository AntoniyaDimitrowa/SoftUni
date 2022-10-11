import java.text.DecimalFormat;
import java.util.Scanner;

public class P11_MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int num1 = Integer.parseInt(input[0]);
        char operator = input[1].charAt(0);
        int num2 = Integer.parseInt(input[2]);
        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println(df.format(calculate(num1, operator, num2)));
    }
    private static double calculate(int num1, char operator, int num2){
        double result = 0.0;
        switch (operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = (num1 * 1.0) / num2;
                break;
        }
        return result;
    }
}
