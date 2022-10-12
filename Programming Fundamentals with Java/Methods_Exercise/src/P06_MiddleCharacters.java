import java.util.Scanner;

public class P06_MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(findMiddleCharacters(input));

    }
    public static String findMiddleCharacters(String input) {
        String result = "";
        if(input.length() % 2 != 0) {
            result = result + input.charAt(input.length() / 2);
        } else {
            result = result + input.charAt((input.length() / 2) - 1) + input.charAt(input.length() / 2);
        }
        return result;
    }
}
