import java.util.Scanner;

public class P04_ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        for(int i = word.length() - 1; i >= 0; i--) {
            System.out.printf("%c",word.charAt(i));
        }
    }
}
