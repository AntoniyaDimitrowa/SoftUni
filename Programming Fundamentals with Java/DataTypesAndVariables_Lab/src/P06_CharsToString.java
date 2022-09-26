import java.util.Scanner;

public class P06_CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "";

        for(int i = 1; i<= 3; i++) {
            char symbol = scanner.nextLine().charAt(0);
            result = result + symbol;
        }
        System.out.println(result);
    }
}
