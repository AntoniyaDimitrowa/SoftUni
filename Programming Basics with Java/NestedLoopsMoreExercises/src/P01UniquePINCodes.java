import java.util.Scanner;

public class P01UniquePINCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumUpperLimit = Integer.parseInt(scanner.nextLine());
        int secondNumUpperLimit = Integer.parseInt(scanner.nextLine());
        int thirdNumUpperLimit = Integer.parseInt(scanner.nextLine());
        boolean isPrime = true;

        for(int num1 = 2; num1 <= firstNumUpperLimit; num1+=2) {
            for(int num2 = 2; num2 <= secondNumUpperLimit; num2++) {
                for(int i = 2; i < num2; i++) {
                    if(num2 % i == 0) {
                        isPrime = false;
                    }
                }
                for(int num3 = 2; num3 <= thirdNumUpperLimit; num3+=2) {
                    if(isPrime) {
                        System.out.printf("%d %d %d%n", num1, num2, num3);
                    }
                }
                isPrime = true;
            }
        }
    }
}
