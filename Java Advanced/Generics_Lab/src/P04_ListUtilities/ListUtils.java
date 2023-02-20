package P04_ListUtilities;

import java.util.Comparator;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if(list.isEmpty()) {
            throw new IllegalArgumentException("The list is empty!");
        }
        T min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if(min.compareTo(list.get(i)) > 0) {
                min = list.get(i);
            }
        }
        return min;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if(list.isEmpty()) {
            throw new IllegalArgumentException("The list is empty!");
        }
        T max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if(max.compareTo(list.get(i)) < 0) {
                max = list.get(i);
            }
        }
        return max;
    }
}
