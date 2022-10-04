import java.util.Arrays;
import java.util.Scanner;

public class P08_MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] != array[i+1] && array[i] + array[i+1] == num) {
                System.out.printf("%d %d%n", array[i], array[i+1]);
            }
        }
    }
}
