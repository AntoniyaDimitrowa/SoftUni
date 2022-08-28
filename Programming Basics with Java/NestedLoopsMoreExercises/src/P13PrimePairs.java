import java.util.Scanner;

public class P13PrimePairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int beginningFirstPair = Integer.parseInt(scanner.nextLine());
        int beginningSecondPair = Integer.parseInt(scanner.nextLine());
        int endFirstPair = Integer.parseInt(scanner.nextLine());
        int endSecondPair = Integer.parseInt(scanner.nextLine());
        boolean isPrime = true;
        for(int firstPair = beginningFirstPair; firstPair <= beginningFirstPair + endFirstPair; firstPair++) {
            for (int secondPair = beginningSecondPair; secondPair <= beginningSecondPair + endSecondPair; secondPair++) {
                for(int i = 2; i < firstPair; i++) {
                    if(firstPair % i == 0) {
                        isPrime = false;
                    }
                }
                for(int i = 2; i < secondPair; i++) {
                    if(secondPair % i == 0) {
                        isPrime = false;
                    }
                }
                if(isPrime) {
                    System.out.printf("%d%d%n", firstPair, secondPair);
                }
                isPrime = true;
            }
        }
    }
}
