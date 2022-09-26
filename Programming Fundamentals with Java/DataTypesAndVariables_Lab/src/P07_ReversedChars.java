import java.util.Scanner;

public class P07_ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "";

        for(int i = 1; i<= 3; i++) {
            char symbol = scanner.nextLine().charAt(0);
            result = result + symbol;
        }

        String reversedResult = "";
        for(int i = result.length() - 1; i >= 0; i--) {
            reversedResult += (result.charAt(i) + " ");
        }
        System.out.println(reversedResult);
    }
}
