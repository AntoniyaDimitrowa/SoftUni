import java.util.*;
import java.util.stream.Collectors;

public class P07_AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> arrays = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        Collections.reverse(arrays);

        for (int i = 0; i < arrays.size(); i++) {
            List<String> result = Arrays.stream(arrays.get(i).trim().split("\\s")).collect(Collectors.toList());
            result.removeAll(Collections.singleton(""));
            for (int j = 0; j < result.size(); j++) {
                int num = Integer.parseInt(result.get(j));
                System.out.print(num + " ");
            }
        }
    }
}
