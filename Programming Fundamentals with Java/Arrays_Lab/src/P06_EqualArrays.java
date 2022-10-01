import java.util.Arrays;
import java.util.Scanner;

public class P06_EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array1 = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int[] array2 = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        if(array1.length != array2.length) {
            System.out.println("Arrays are not identical.");
        } else {
            boolean differenceFound = false;
            int sum = 0;
            for (int i = 0; i < array1.length; i++) {
                if(array1[i] != array2[i]) {
                    System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                    differenceFound = true;
                    sum = 0;
                    break;
                } else {
                    sum += array1[i];
                }
            }
            if(!differenceFound) {
                System.out.printf("Arrays are identical. Sum: %d", sum);
            }
        }
    }
}
