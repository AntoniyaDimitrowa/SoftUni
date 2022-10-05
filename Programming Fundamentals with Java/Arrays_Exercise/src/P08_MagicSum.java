import java.util.Arrays;
import java.util.Scanner;

public class P08_MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] != array[j] && array[i] + array[j] == num) {
                    System.out.printf("%d %d%n", array[i], array[j]);
                }
            }
        }
    }
}
