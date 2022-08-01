import java.util.Scanner;

public class P03SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while(sum < firstNum) {
            int currNum = Integer.parseInt(scanner.nextLine());
            sum = sum + currNum;
        }

        System.out.println(sum);
    }
}
