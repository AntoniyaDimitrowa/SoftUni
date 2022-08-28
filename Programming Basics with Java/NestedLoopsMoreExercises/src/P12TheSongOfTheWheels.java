import java.util.Scanner;

public class P12TheSongOfTheWheels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        int password = 0;

        for(int firstDigit = 1; firstDigit <= 9; firstDigit++) {
            for(int secondDigit = 1; secondDigit <= 9; secondDigit++) {
                for(int thirdDigit = 1; thirdDigit <= 9; thirdDigit++) {
                    for(int forthDigit = 1; forthDigit <= 9; forthDigit++) {
                        if((firstDigit * secondDigit + thirdDigit * forthDigit) == num) {
                            if(firstDigit < secondDigit && thirdDigit > forthDigit) {
                                System.out.printf("%d%d%d%d ", firstDigit, secondDigit, thirdDigit, forthDigit);
                                counter++;
                                if(counter == 4) {
                                    password = 1000 * firstDigit + 100 * secondDigit + 10 * thirdDigit + forthDigit;
                                }
                            }
                        }
                    }
                }
            }
        }

        if(counter >= 4) {
            System.out.println();
            System.out.printf("Password: %d", password);
        } else {
            if(counter > 0) {
                System.out.println();
                System.out.printf("No!");
            } else {
                System.out.printf("No!");
            }

        }

    }
}
