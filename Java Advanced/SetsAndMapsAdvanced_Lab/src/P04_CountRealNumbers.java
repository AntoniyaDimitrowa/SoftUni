import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> numbersCount = new LinkedHashMap<>();
        String[] input = scanner.nextLine().split("\\s+");
        for (int i = 0; i < input.length; i++) {
            String element = input[i];
            if(!numbersCount.containsKey(element)) {
                int count = 0;
                for (int j = 0; j < input.length; j++) {
                    if(element.equals(input[j])) {
                        count++;
                    }
                }
                numbersCount.put(element, count);
            }
            int count = 0;
        }
        for (Map.Entry<String, Integer> entry : numbersCount.entrySet()) {
            double element = Double.parseDouble(entry.getKey());
            System.out.printf("%.1f -> %d%n", element, entry.getValue());
        }
    }
}
