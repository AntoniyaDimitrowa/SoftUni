import java.util.Scanner;

public class P06_ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        result.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(i-1)) {
                result.append(str.charAt(i));
            }
        }
        System.out.println(result);
    }
}
