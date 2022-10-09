import java.util.Scanner;

public class P10_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        System.out.println(getMultipleOfEvensAndOdds(num));
    }
    public static int getSumOfEvenDigits(int num) {
        int sum = 0;
        while(num != 0) {
            int digit = num % 10;
            if(digit % 2 == 0) {
                sum += digit;
            }
            num/=10;
        }
        return sum;
    }
    public static int getSumOfOddDigits(int num) {
        int sum = 0;
        while(num != 0) {
            int digit = num % 10;
            if(digit % 2 != 0) {
                sum += digit;
            }
            num/=10;
        }
        return sum;
    }
    public static int getMultipleOfEvensAndOdds(int num) {
        return getSumOfEvenDigits(num) * getSumOfOddDigits(num);
    }
}
