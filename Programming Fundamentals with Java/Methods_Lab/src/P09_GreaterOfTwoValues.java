import java.util.Scanner;

public class P09_GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        switch (type) {
            case "int":
                int num1 = Integer.parseInt(scanner.nextLine());
                int num2 = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(num1, num2));
                break;
            case "char":
                char firstChar = scanner.nextLine().charAt(0);
                char secondChar = scanner.nextLine().charAt(0);
                System.out.println(getMax(firstChar, secondChar));
                break;
            case "string":
                String firstString = scanner.nextLine();
                String secondString = scanner.nextLine();
                System.out.println(getMax(firstString, secondString));
                break;
        }
    }
    public static int getMax(int firstNum, int secondNum) {
        if(firstNum > secondNum) {
            return firstNum;
        } else {
            return secondNum;
        }
    }
    public static char getMax(char first, char second) {
        if(first > second) {
            return first;
        } else {
            return second;
        }
    }
    public static String getMax(String first, String second) {
        if(first.compareTo(second) >= 0) {
            return first;
        } else {
            return second;
        }
    }
}
