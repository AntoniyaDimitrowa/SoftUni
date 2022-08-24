import java.util.Scanner;

public class P03LuckyNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        for(int firstDigit = 1; firstDigit <= 9; firstDigit++) {
            for(int secondDigit = 1; secondDigit <= 9; secondDigit++) {
                for(int thirdDigit = 1; thirdDigit <= 9; thirdDigit++) {
                    for(int forthDigit = 1; forthDigit <= 9; forthDigit++) {
                        if(secondDigit + firstDigit == thirdDigit + forthDigit) {
                            if(num % (firstDigit + secondDigit) == 0) {
                                System.out.printf("%d%d%d%d ", firstDigit, secondDigit, thirdDigit, forthDigit);
                            }
                        }
                    }
                }
            }
        }
    }
}
