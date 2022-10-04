import java.util.Arrays;
import java.util.Scanner;

public class P07_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int start = 0;
        int count = 0;
        int max = 0;
        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i] == array[i + 1])
            {
                count++;
                if (count > max)
                {
                    start = i - count + 1;
                    max = count;
                }
            }
            else
            {
                count = 0;
            }
        }
        for (int i = start; i <= start + max; i++)
        {
            System.out.printf("%d ", array[i]);
        }
    }
}
