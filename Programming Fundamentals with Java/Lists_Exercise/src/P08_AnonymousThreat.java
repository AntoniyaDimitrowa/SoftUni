import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08_AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while(!command.equals("3:1")) {
            String[] commandArr = command.split(" ");
            if(commandArr[0].equals("merge")) {
                int startIndex = Integer.parseInt(commandArr[1]);
                int endIndex = Integer.parseInt(commandArr[2]);
                if(startIndex < 0) {
                    startIndex = 0;
                }
                if(endIndex >= strings.size()) {
                    endIndex = strings.size() - 1;
                }
                String result = "";
                for (int i = startIndex; i <= endIndex; i++) {
                    result += strings.get(i);
                }
                strings.set(0, result);
                for (int i = 1; i < strings.size()-1; i++) {
                    strings.remove(i);
                    i--;
                }

            } else if(commandArr[0].equals("divide")) {
                int index = Integer.parseInt(commandArr[1]);
                int partitions = Integer.parseInt(commandArr[2]);


            }
            command = scanner.nextLine();
        }
        for (String item : strings) {
            System.out.print(item + " ");
        }
    }
}
