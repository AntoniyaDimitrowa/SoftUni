import java.util.Scanner;

public class P04CarNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int intervalBeginning = Integer.parseInt(scanner.nextLine());
        int intervalEnd = Integer.parseInt(scanner.nextLine());

        for(int firstDigit = intervalBeginning; firstDigit <= intervalEnd; firstDigit++) {
            for(int secondDigit = intervalBeginning; secondDigit <= intervalEnd; secondDigit++) {
                for(int thirdDigit = intervalBeginning; thirdDigit <= intervalEnd; thirdDigit++) {
                    for(int forthDigit = intervalBeginning; forthDigit <= intervalEnd; forthDigit++) {
                        if((firstDigit % 2 == 0 && forthDigit % 2 != 0) || (firstDigit % 2 != 0 && forthDigit % 2 == 0)) {
                            if(firstDigit > forthDigit) {
                                if((secondDigit + thirdDigit) % 2 == 0) {
                                    System.out.printf("%d%d%d%d ", firstDigit, secondDigit, thirdDigit, forthDigit);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
