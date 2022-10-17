import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String[] command = scanner.nextLine().split(" ");
        while(!command[0].equals("end")) {
            if(command[0].equals("Delete")) {
                int element = Integer.parseInt(command[1]);
                numbers.remove(Integer.valueOf(element));
            } else if(command[0].equals("Insert")) {
                int element = Integer.parseInt(command[1]);
                int position = Integer.parseInt(command[2]);
                numbers.add(position, element);
            }
            command = scanner.nextLine().split(" ");
        }

        for (int item : numbers) {
            System.out.print(item + " ");
        }
    }
}
