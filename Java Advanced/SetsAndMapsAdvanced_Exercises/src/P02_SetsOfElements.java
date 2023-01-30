import java.util.*;

public class P02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lengths = scanner.nextLine().split("\\s+");
        int set1length = Integer.parseInt(lengths[0]);
        int set2length = Integer.parseInt(lengths[1]);
        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();

        for (int i = 0; i < set1length; i++) {
            int currNum = Integer.parseInt(scanner.nextLine());
            set1.add(currNum);
        }
        for (int i = 0; i < set2length; i++) {
            int currNum = Integer.parseInt(scanner.nextLine());
            set2.add(currNum);
        }

        List<Integer> repeatedNumbers = new ArrayList<>();
        for (int element : set1) {
            if(set2.contains(element)) {
                repeatedNumbers.add(element);
            }
        }

        repeatedNumbers.forEach(num -> System.out.print(num + " "));
    }
}
