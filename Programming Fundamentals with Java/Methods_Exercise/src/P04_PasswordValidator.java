import java.util.Scanner;

public class P04_PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if(!isCorrectLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        if(!containsOnlyLettersAndDigits(password)) {
            System.out.println("Password must consist only of letters and digits");
        }

        if(!containsAtLeastTwoDigits(password)) {
            System.out.println("Password must have at least 2 digits");
        }

        if(isCorrectLength(password) && containsAtLeastTwoDigits(password) && containsOnlyLettersAndDigits(password)) {
            System.out.println("Password is valid");
        }
    }

    private static boolean isCorrectLength(String password) {
        if (password.length() < 6 || password.length() > 10) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean containsOnlyLettersAndDigits(String password) {
        for (int i = 0; i < password.length(); i++) {
            int symbolASCII = password.charAt(i);
            if(!((symbolASCII >= 97 && symbolASCII <= 122) || (symbolASCII >= 65 && symbolASCII <= 90) || (symbolASCII >= 48 && symbolASCII <= 57))) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsAtLeastTwoDigits(String password) {
        int digitsCount = 0;
        for (int i = 0; i < password.length(); i++) {
            int symbolASCII = password.charAt(i);
            if(symbolASCII >= 48 && symbolASCII <= 57) {
                digitsCount++;
            }
        }
        if(digitsCount > 1) {
            return true;
        } else {
            return false;
        }
    }
}
