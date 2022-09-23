import java.math.BigDecimal;
import java.util.Scanner;

public class P03_ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numsCount = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = new BigDecimal(0);

        for(int i = 1; i <= numsCount; i++) {
            BigDecimal currNum = new BigDecimal(scanner.nextLine());
            sum = sum.add(currNum);
        }
        System.out.println(sum);
    }
}
