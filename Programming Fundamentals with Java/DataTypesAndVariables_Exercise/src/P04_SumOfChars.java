import java.util.Scanner;

public class P04_SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int charsCount = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for(int i = 1; i <= charsCount; i++){
            char letter = scanner.nextLine().charAt(0);
            sum += letter;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
