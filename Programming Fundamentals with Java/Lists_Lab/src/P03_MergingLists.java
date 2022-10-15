import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        int minSize = Math.min(list1.size(), list2.size());
        for (int i = 0; i < minSize; i++) {
            result.add(list1.get(i));
            result.add(list2.get(i));
        }

        if(list1.size() > list2.size()) {
            result.addAll(list1.subList(minSize, list1.size()));
        } else if(list1.size() < list2.size()) {
            result.addAll(list2.subList(minSize, list2.size()));
        }
        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }
}
