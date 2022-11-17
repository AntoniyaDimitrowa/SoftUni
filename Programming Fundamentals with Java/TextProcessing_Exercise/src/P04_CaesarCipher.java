import java.util.Scanner;

public class P04_CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char currChar = text.charAt(i);
            int newCharASCII = currChar + 3;
            char newChar = (char) newCharASCII;
            result += newChar;
        }

        System.out.println(result);
    }
}
