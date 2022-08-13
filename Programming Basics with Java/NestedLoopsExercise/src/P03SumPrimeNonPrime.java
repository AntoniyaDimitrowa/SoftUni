import java.util.Scanner;

public class P03SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int sumPrime = 0;
        int sumNonPrime = 0;

        while(!command.equals("stop")) {
            int currNum = Integer.parseInt(command);
            if(currNum < 0) {
                System.out.println("Number is negative.");
                command = scanner.nextLine();
                continue;
            }
            boolean isPrime = true;
            for(int divider = 2; divider < currNum; divider++) {
                if(currNum % divider == 0) {
                    isPrime = false;
                    sumNonPrime += currNum;
                    break;
                }
            }
            if(isPrime) {
                sumPrime += currNum;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d %n", sumPrime);
        System.out.printf("Sum of all non prime numbers is: %d", sumNonPrime);
    }
}
