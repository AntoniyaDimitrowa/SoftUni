import java.util.Scanner;

public class P06_StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int result = 0;
        int i = num;
        while (i != 0) {
            int digit = i % 10;
            int digitsFactorial = 1;
            for(int j = digit; j > 0; j--) {
                digitsFactorial = digitsFactorial * j;
            }
            result = result + digitsFactorial;
            i = i / 10;
        }

        if(result == num) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
