import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        int[] input =
                Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int specialNum = input[0];
        int specialNumPower = input[1];

        for (int i = 0; i < numbers.size(); i++) {
            if(specialNum == numbers.get(i)) {
                int specialNumIndex = i;
                int beginningIndex = specialNumIndex - specialNumPower;
                int endingIndex = specialNumIndex + specialNumPower;

                if(beginningIndex < 0) {
                    beginningIndex = 0;
                }
                if(endingIndex >= numbers.size()) {
                    endingIndex = numbers.size() - 1;
                }

                for (int j = beginningIndex; j <= endingIndex; j++) {
                    int index = beginningIndex;
                    numbers.set(j, 0);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.println(sum);
    }
}
