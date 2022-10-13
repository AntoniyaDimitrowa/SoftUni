import java.util.Scanner;

public class P10_TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= number; i++) {
            if(isTopNumber(i)) {
                System.out.println(i);
            }
        }
    }
    public static boolean isTopNumber(int number) {
        int oddDigitsCount = 0;
        int sum = 0;
        while(number > 0) {
            int digit = number % 10;
            if(digit % 2 != 0) {
                oddDigitsCount++;
            }
            sum += digit;
            number /= 10;
        }
        if(oddDigitsCount > 0 && sum % 8 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
