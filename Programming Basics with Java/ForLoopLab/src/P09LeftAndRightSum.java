import java.util.Scanner;

public class P09LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i <= n; i++)
        {
            int num = Integer.parseInt(scanner.nextLine());
            sum1 = sum1 + num;
        }

        for (int i = n; i < 2 * n; i++)
        {
            int num = Integer.parseInt(scanner.nextLine());
            sum2 = sum2 + num;
        }

        if (sum1 == sum2)
        {
            System.out.printf("Yes, sum = %d", sum1);
        }
        else if (sum2 > sum1)
        {
            System.out.printf("No, diff = %d", sum2 - sum1);
        }
        else
        {
            System.out.printf("No, diff = %d", sum1 - sum2);
        }
    }
}
