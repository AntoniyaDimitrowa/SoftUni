import java.util.Scanner;

public class P04_PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder newPassword = new StringBuilder();
        String[] commandArr = scanner.nextLine().split(" ");
        while(!commandArr[0].equals("Done")) {
            String currCommand = commandArr[0];
            switch (currCommand) {
                case "TakeOdd":
                    for (int i = 0; i < input.length(); i++) {
                        if(i % 2 != 0) {
                            newPassword.append(input.charAt(i));
                        }
                    }
                    System.out.println(newPassword);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandArr[1]);
                    int length = Integer.parseInt(commandArr[2]);
                    newPassword = new StringBuilder(newPassword
                            .delete(index, index + length));
                    System.out.println(newPassword);
                    break;
                case "Substitute":
                    String substringFromInput = commandArr[1];
                    String substitute = commandArr[2];
                    if(newPassword.toString().contains(substringFromInput)) {
                        newPassword = new StringBuilder(newPassword.toString().replace(substringFromInput, substitute));
                        System.out.println(newPassword);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            commandArr = scanner.nextLine().split(" ");
        }
        System.out.println("Your password is: " + newPassword);
    }
}
