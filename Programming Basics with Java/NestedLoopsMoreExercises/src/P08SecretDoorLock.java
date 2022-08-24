import java.util.Scanner;

public class P08SecretDoorLock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstDigitUpperLimit = Integer.parseInt(scanner.nextLine());
        int secondDigitUpperLimit = Integer.parseInt(scanner.nextLine());
        int lastDigitUpperLimit = Integer.parseInt(scanner.nextLine());
        boolean isPrime = true;

        for(int digit1 = 2; digit1 <= firstDigitUpperLimit; digit1+=2) {
            for(int digit2 = 2; digit2 <= secondDigitUpperLimit; digit2++) {
                for(int i = 2; i < digit2; i++) {
                    if(digit2 % i == 0) {
                        isPrime = false;
                    }
                }
                for(int digit3 = 2; digit3 <= lastDigitUpperLimit; digit3+=2) {
                    if(isPrime) {
                        System.out.printf("%d %d %d%n", digit1, digit2, digit3);
                    }
                }
                isPrime = true;
            }
        }
    }
}
