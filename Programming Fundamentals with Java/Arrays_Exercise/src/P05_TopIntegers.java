import java.util.Arrays;
import java.util.Scanner;

public class P05_TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int i = 0; i < array.length; i++) {
            boolean isTopInteger = true;
            for (int j = i+1; j < array.length; j++) {
                if(array[i] <= array[j]) {
                    isTopInteger = false;
                }
            }
            if(isTopInteger) {
                System.out.printf("%d ", array[i]);
            }
        }
    }
}
