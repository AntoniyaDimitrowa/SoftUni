import java.util.Scanner;

public class P09_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while(!command.equals("END")) {
            String numberBackward = "";
            for (int i = command.length() - 1; i >= 0 ; i--) {
                numberBackward += command.charAt(i);
            }
            if(numberBackward.equals(command)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            command = scanner.nextLine();
        }

    }
}
