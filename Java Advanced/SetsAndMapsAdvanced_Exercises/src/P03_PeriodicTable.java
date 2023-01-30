import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Set<String> chemicalElements = new TreeSet<>();
        for (int i = 0; i < num; i++) {
            String[] currElements = scanner.nextLine().split("\\s+");
            Collections.addAll(chemicalElements, currElements);
        }
        chemicalElements.forEach(element -> System.out.print(element + " "));
    }
}
