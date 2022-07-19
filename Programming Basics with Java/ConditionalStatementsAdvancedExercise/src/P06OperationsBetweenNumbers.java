import java.util.Scanner;

public class P06OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();

        double result = 0.0;
        String evenOrOdd = "";
        boolean divideByZero = false;
        if(operator.equals("+")) {
            result = num1 + num2;
            if(result%2==0) {
                evenOrOdd = "even";
            } else {
                evenOrOdd = "odd";
            }
        } else if(operator.equals("-")) {
            result = num1 - num2;
            if(result%2==0) {
                evenOrOdd = "even";
            } else {
                evenOrOdd = "odd";
            }
        } else if(operator.equals("*")) {
            result = num1 * num2;
            if(result%2==0) {
                evenOrOdd = "even";
            } else {
                evenOrOdd = "odd";
            }
        } else if(operator.equals("/")) {
            if(num2!=0) {
                result = num1*1.0 / num2;
            } else {
                divideByZero = true;
            }
        } else if(operator.equals("%")) {
            if(num2!=0) {
                result = num1*1.0 % num2;
            } else {
                divideByZero = true;
            }
        }
        if(divideByZero == false) {
            switch (operator) {
                case "+":
                case "-":
                case "*":
                    System.out.printf("%d %s %d = %.0f - %s", num1, operator, num2, result, evenOrOdd);
                    break;
                case "/":
                    System.out.printf("%d %s %d = %.2f", num1, operator, num2, result);
                    break;
                case "%":
                    System.out.printf("%d %s %d = %.0f", num1, operator, num2, result);
                    break;
            }
        } else {
            System.out.printf("Cannot divide %d by zero", num1);
        }
    }
}
