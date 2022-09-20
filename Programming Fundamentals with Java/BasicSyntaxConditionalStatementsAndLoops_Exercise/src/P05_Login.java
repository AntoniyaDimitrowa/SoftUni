import java.util.Scanner;

public class P05_Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = "";

        for(int i = username.length() - 1; i >= 0; i--) {
            password = password + username.charAt(i);
        }
        int wrongPasswordCounter = 0;
        String input = scanner.nextLine();
        while(!input.equals(password)) {
            wrongPasswordCounter++;
            if(wrongPasswordCounter == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            input = scanner.nextLine();
        }
        if(wrongPasswordCounter != 4) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
