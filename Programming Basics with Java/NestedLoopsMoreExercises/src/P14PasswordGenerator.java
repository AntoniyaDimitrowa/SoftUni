import java.util.Scanner;

public class P14PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());
        int l1 = l;
        int l2 = l;

        for(int firstNum = 1; firstNum <= n; firstNum++) {
            for (int secondNum = 1; secondNum <= n; secondNum++) {
                for(char firstLetter = 'a'; firstLetter <= 'z'; firstLetter++) {
                    l1--;
                    for(char secondLetter = 'a'; secondLetter <= 'z'; secondLetter++) {
                        l2--;
                        for(int thirdNum = 1; thirdNum <= n; thirdNum++) {
                            if(thirdNum > firstNum && thirdNum > secondNum) {
                                System.out.printf("%d%d%c%c%d ", firstNum, secondNum, firstLetter, secondLetter, thirdNum);
                            }
                        }
                        if(l2 == 0) {
                            l2 = l;
                            break;
                        }
                    }
                    if(l1 == 0) {
                        l1 = l;
                        break;
                    }
                }
            }
        }
    }
}
