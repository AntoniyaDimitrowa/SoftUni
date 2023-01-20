import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P06_RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int position = Integer.parseInt(scanner.nextLine());
        Map<Integer, Long> memo = new HashMap<>();
        long result = getFibonacci(position, memo);
        System.out.println(result);
    }
    public static long getFibonacci(int position,  Map<Integer, Long> memo) {
        long result;
        if (position == 1 || position == 0) {
            return 1;
        } else {
            if (memo.containsKey(position)) {
                return memo.get(position);
            } else {
                result = getFibonacci(position - 1, memo) + getFibonacci(position - 2, memo);
                memo.put(position, result);
            }
            return result;
        }
    }
}
