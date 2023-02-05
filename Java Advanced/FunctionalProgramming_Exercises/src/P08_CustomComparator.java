import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<Integer> sortComparator = (a, b) -> {
            if(a % 2 == 0) {
                if (b % 2 == 0) {
                    if(a < b) {
                        return -1;
                    } else if(a > b){
                        return 1;
                    }
                } else {
                    return -1;
                }
            } else {
                if (b % 2 == 0) {
                    return 1;
                } else {
                    if(a < b) {
                        return -1;
                    } else if(a > b){
                        return 1;
                    }
                }
            }
            return 0;
        };

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());

        numbers.sort(sortComparator);
        numbers.forEach(num -> System.out.print(num + " "));
    }
}
