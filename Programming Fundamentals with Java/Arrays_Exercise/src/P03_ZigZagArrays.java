import java.util.Arrays;
import java.util.Scanner;

public class P03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array1 = new int[n];
        int[] array2 = new int[n];

        for(int i = 0; i < n; i++) {
            int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            if(i % 2 == 0) {
                array1[i] = nums[0];
                array2[i] = nums[1];
            } else {
                array1[i] = nums[1];
                array2[i] = nums[0];
            }
        }
        for (int i = 0; i < array1.length; i++) {
            System.out.printf("%d ", array1[i]);

        }
        System.out.println();
        for (int i = 0; i < array2.length; i++) {
            System.out.printf("%d ", array2[i]);

        }
    }
}
