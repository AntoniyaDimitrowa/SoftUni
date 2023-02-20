package GenericBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Box<String>> boxes = new ArrayList<>();
        int numberOfElements = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfElements; i++) {
            String input = scanner.nextLine();
            Box<String> box = new Box<>(input);
            boxes.add(box);
        }

        Box<String> boxToCompare = new Box<>(scanner.nextLine());
        int count = countGreaterResults(boxes, boxToCompare);

        System.out.println(count);
    }

    static <T extends Comparable<T>> int countGreaterResults(List<T> data, T element) {
        int count = 0;
        for (T el : data) {
            int res = el.compareTo(element);
            if(res > 0) {
                count++;
            }
        }
        return count;
    }
}
