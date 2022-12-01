import java.util.Scanner;

public class P04_PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        String[] commandArr = scanner.nextLine().split(" ");
        while(!commandArr[0].equals("Done")) {
            String currCommand = commandArr[0];
            switch (currCommand) {
                case "TakeOdd":
                    password = getCharsOnOddIndexes(password);;
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandArr[1]);
                    int length = Integer.parseInt(commandArr[2]);
                    String substringToRemove = password.substring(index, index + length);
                    password = password.replaceFirst(substringToRemove, "");
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substringToReplace = commandArr[1];
                    String substitute = commandArr[2];
                    if(password.contains(substringToReplace)) {
                        password = password.replaceAll(substringToReplace, substitute);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            commandArr = scanner.nextLine().split(" ");
        }
        System.out.println("Your password is: " + password);
    }

    private static String getCharsOnOddIndexes(String password) {
        StringBuilder newPassword = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            if(i % 2 != 0) {
                newPassword.append(password.charAt(i));
            }
        }
        return newPassword.toString();
    }
}
