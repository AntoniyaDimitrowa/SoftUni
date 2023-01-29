import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());
        for (int i = 0; i < 3; i++) {
            System.out.print(nums.get(i) + " ");
        }
    }
}
