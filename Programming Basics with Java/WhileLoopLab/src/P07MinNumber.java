import java.util.Scanner;

public class P07MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int minNum = Integer.MAX_VALUE;

        while (!command.equals("Stop")) {
            int currNum = Integer.parseInt(command);
            if(currNum < minNum) {
                minNum = currNum;
            }
            command = scanner.nextLine();
        }
        System.out.println(minNum);
    }
}
