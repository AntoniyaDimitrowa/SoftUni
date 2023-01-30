import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class P08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double[]> students = new TreeMap<>();
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            String name = scanner.nextLine();
            String[] input = scanner.nextLine().split("\\s+");
            Double[] grades = new Double[input.length];
            for (int j = 0; j < input.length; j++) {
                grades[j] = Double.parseDouble(input[j]);
            }
            students.put(name, grades);
        }
        for (Map.Entry<String, Double[]> entry : students.entrySet()) {
            String name = entry.getKey();
            Double[] grades = entry.getValue();
            BigDecimal sum = BigDecimal.valueOf(0);
            for (int i = 0; i < grades.length; i++) {
                sum = sum.add(BigDecimal.valueOf(grades[i]));
            }
            System.out.printf("%s is graduated with %f%n", name, (sum.divide(BigDecimal.valueOf(grades.length))).stripTrailingZeros());
        }
    }
}
