import java.util.Scanner;

public class P08SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int i = 1;

        while (num != 0) {
            if(i % 2 != 0) {
                System.out.println(i);
                num--;
                sum += i;
            }
            i++;
        }
        System.out.printf("Sum: %d", sum);
    }
}
