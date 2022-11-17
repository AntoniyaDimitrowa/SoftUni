import java.util.Scanner;

public class P01_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] usernames = scanner.nextLine().split(", ");

        for (String currUsername : usernames) {
            if(isValid(currUsername)) {
                System.out.println(currUsername);
            }
        }
    }

    public static boolean isValid (String username) {
        if(username.length() < 3 || username.length() > 16) {
            return false;
        }

        for (int i = 0; i < username.length(); i++) {
            char currChar = username.charAt(i);
            if(!Character.isLetterOrDigit(currChar) && currChar != '-' && currChar != '_') {
                return false;
            }
        }
        return true;
    }
}
