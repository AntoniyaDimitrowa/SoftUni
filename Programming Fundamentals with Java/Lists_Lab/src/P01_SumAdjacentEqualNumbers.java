import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Double::parseDouble)
                        .collect(Collectors.toList());

        for (int i = 0; i < numbers.size() - 1; i++) {
            double currNum = numbers.get(i);
            double nextNum = numbers.get(i + 1);
            if(currNum == nextNum) {
                numbers.set(i, currNum + nextNum);
                numbers.remove(i+1);
                i = -1;
            }
        }

        System.out.println(joinElementsByDelimiter(numbers, " "));
    }
    public static String joinElementsByDelimiter(List<Double> list, String delimiter) {
        DecimalFormat df = new DecimalFormat("0.#");
        String result = "";
        for(double item : list) {
            String numDf = df.format(item) + delimiter;
            result += numDf;
        }
        return result;
    }
}
