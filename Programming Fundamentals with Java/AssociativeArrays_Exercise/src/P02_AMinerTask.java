import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        while (!command.equals("stop")) {
            String resource = command;
            int quantity = Integer.parseInt(scanner.nextLine());
            if(result.containsKey(resource)) {
                result.put(resource, result.get(resource) + quantity);
            } else {
                result.put(resource, quantity);
            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
