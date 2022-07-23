import java.util.Scanner;

public class P10OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 1; i <= n; i++)
        {
            int num = Integer.parseInt(scanner.nextLine());
            if(i % 2 == 0) {
                sumEven = sumEven + num;
            } else {
                sumOdd = sumOdd + num;
            }
        }

        if (sumEven == sumOdd)
        {
            System.out.println("Yes");
            System.out.printf("Sum = %d", sumEven);
        }
        else if (sumOdd > sumEven)
        {
            System.out.println("No");
            System.out.printf("Diff = %d", sumOdd - sumEven);
        }
        else
        {
            System.out.println("No");
            System.out.printf("Diff = %d", sumEven - sumOdd);
        }
    }
}
