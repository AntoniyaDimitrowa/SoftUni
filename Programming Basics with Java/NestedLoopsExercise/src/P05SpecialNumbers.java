import java.util.Scanner;

public class P05SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        for(int i = 1111; i <= 9999; i++) {
            int currNum = i;
            boolean isSpecial = true;
            for(int j = 1; j <= 4; j++) {
                int lastDigit = currNum % 10;
                if(lastDigit == 0) {
                    isSpecial = false;
                    break;
                } else {
                    if (num % lastDigit != 0) {
                        isSpecial = false;
                        break;
                    }
                }
                currNum = currNum / 10;
            }
            if(isSpecial) {
                System.out.printf("%d ", i);
            }
        }
    }
}
