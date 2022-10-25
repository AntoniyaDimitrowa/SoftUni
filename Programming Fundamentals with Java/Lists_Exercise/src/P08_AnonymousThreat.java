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

                if(endIndex < 0 || startIndex > strings.size() - 1) {
                    command = scanner.nextLine();
                    continue;
                }
                if(startIndex < 0) {
                    startIndex = 0;
                }
                if(endIndex >= strings.size()) {
                    endIndex = strings.size() - 1;
                }

                String result = "";
                for (int i = startIndex; i <= endIndex; i++) {
                    result += strings.remove(startIndex);
                }
                strings.add(startIndex, result);

            } else if(commandArr[0].equals("divide")) {
                int index = Integer.parseInt(commandArr[1]);
                int partitions = Integer.parseInt(commandArr[2]);
                if(index > -1 && index < strings.size()) {
                    String[] result = new String[partitions];
                    String element = strings.get(index);
                    if(partitions < element.length()) {
                        if (element.length() % partitions == 0) {
                            int charsInPartition = element.length() / partitions;
                            int positionInElement = 0;
                            for (int i = 0; i < partitions; i++) {
                                result[i] = "";
                                for (int j = 1; j <= charsInPartition; j++) {
                                    result[i] += element.charAt(positionInElement);
                                    positionInElement++;
                                }
                            }
                        } else {
                            int charsInPartition = element.length() / partitions;
                            int positionInElement = 0;
                            for (int i = 0; i < partitions - 1; i++) {
                                result[i] = "";
                                for (int j = 1; j <= charsInPartition; j++) {
                                    result[i] += element.charAt(positionInElement);
                                    positionInElement++;
                                }
                            }
                            for (int j = positionInElement; j < element.length(); j++) {
                                result[partitions-1] += element.charAt(j);
                            }
                        }
                        strings.remove(index);
                        for (int i = partitions - 1; i >= 0; i--) {
                            strings.add(index, result[i]);
                        }
                    }
                }

            }
            command = scanner.nextLine();
        }
        for (String item : strings) {
            System.out.print(item + " ");
        }
    }
}
