import java.util.Scanner;

public class P05_Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int letters = Integer.parseInt(scanner.nextLine());
        String result = "";
        for(int i = 1; i <= letters; i++) {
            int code = Integer.parseInt(scanner.nextLine());
            int mainDigit = code % 10;
            if(mainDigit == 0) {
                result += " ";
                continue;
            }
            int digitsCount = 0;
            while(code != 0) {
                code /= 10;
                digitsCount++;
            }
            int offset = (mainDigit - 2) * 3;
            if(mainDigit == 8 || mainDigit == 9) {
                offset += 1;
            }
            int index = offset + digitsCount - 1;
            char letter = (char)(index + 97);
            result = result + letter;
        }
        System.out.println(result);
    }
}
