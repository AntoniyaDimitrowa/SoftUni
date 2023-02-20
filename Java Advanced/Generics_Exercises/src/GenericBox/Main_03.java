package GenericBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        List<Box> boxes = new ArrayList<>();

        for (int i = 0; i < numberOfLines; i++) {
            String data = scanner.nextLine();
            Box<String> box = new Box<>(data);
            boxes.add(box);
        }

        int[] indexes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int index1 = indexes[0];
        int index2 = indexes[1];

        swap(boxes, index1, index2);

        boxes.forEach(b -> System.out.println(b));
    }

    public static <T> void swap(List<T> list, int index1, int index2) {
        T firstElement = list.get(index1);
        T secondElement = list.get(index2);

        list.set(index1, secondElement);
        list.set(index2, firstElement);
    }
}
