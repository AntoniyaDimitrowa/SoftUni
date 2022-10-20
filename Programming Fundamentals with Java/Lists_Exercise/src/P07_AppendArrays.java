import java.util.*;
import java.util.stream.Collectors;

public class P07_AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> arrays = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        Collections.reverse(arrays);
        System.out.println(arrays.toString().replaceAll("[\\[\\],]", ""));
    }
}
