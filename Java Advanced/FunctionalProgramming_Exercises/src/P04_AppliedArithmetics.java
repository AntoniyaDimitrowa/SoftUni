import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class P04_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(elem -> Integer.parseInt(elem))
                .toArray();

        BiFunction<int[], String, int[]> applyArithmetic = (numArr, operation) -> {
            switch (operation) {
                case "add":
                    numArr = Arrays.stream(numArr).map(num -> num + 1).toArray();
                    break;
                case "multiply":
                    numArr = Arrays.stream(numArr).map(num -> num * 2).toArray();
                    break;
                case "subtract":
                    numArr = Arrays.stream(numArr).map(num -> num - 1).toArray();
                    break;
                case "print":
                    System.out.println(Arrays.stream(numArr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
                    break;
            }
            return numArr;
        };

        String operation = scanner.nextLine();
        while (!operation.equals("end")) {
            numbers = applyArithmetic.apply(numbers, operation);
            operation = scanner.nextLine();
        }

    }
}
