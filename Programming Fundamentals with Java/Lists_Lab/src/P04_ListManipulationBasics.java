import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04_ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while(!input.equals("end")) {
            String[] commandArr = input.split(" ");
            String command = commandArr[0];
            if(command.equals("Add")) {
                int num = Integer.parseInt(commandArr[1]);
                list.add(num);
            }
            input = scanner.nextLine();
        }
    }
}
