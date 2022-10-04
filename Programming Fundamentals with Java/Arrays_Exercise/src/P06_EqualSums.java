import java.util.Arrays;
import java.util.Scanner;

public class P06_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        boolean isFound = false;
        for (int i = 0; i < array.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft += array[j];
            }
            for (int j = i+1; j < array.length; j++) {
                sumRight += array[j];
            }
            if(sumLeft == sumRight) {
                System.out.println(i);
                isFound = true;
                break;
            }
        }
        if(!isFound) {
            System.out.println("no");
        }
    }
}
