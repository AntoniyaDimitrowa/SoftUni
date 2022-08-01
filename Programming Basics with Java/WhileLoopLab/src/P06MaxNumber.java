import java.util.Scanner;

public class P06MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int maxNum = Integer.MIN_VALUE;

        while (!command.equals("Stop")) {
            int currNum = Integer.parseInt(command);
            if(currNum > maxNum) {
                maxNum = currNum;
            }
            command = scanner.nextLine();
        }
        System.out.println(maxNum);
    }
}
