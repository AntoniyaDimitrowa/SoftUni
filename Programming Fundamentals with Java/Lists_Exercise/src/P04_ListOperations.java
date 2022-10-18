import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04_ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String input = scanner.nextLine();
        while(!input.equals("End")) {
            String[] command = input.split(" ");
            if(command[0].equals("Add")) {
                int element = Integer.parseInt(command[1]);
                numbers.add(Integer.valueOf(element));
            } else if(command[0].equals("Remove")) {
                int index = Integer.parseInt(command[1]);
                if(index < 0 || index >= numbers.size()) {
                    System.out.println("Invalid index");
                } else {
                    numbers.remove(index);
                }
            } else if(command[0].equals("Insert")) {
                int element = Integer.parseInt(command[1]);
                int index = Integer.parseInt(command[2]);
                if(index < 0 || index >= numbers.size()) {
                    System.out.println("Invalid index");
                } else {
                    numbers.add(index, element);
                }
            } else if(command[0].equals("Shift")) {
                int count = Integer.parseInt(command[2]);
                if (command[1].equals("left")){
                    for (int i = 1; i <= count; i++) {
                        int firstNum = numbers.get(0);
                        numbers.remove(0);
                        numbers.add(firstNum);
                    }
                } else if (command[1].equals("right")){
                    for (int i = 1; i <= count; i++) {
                        int lastNum = numbers.get(numbers.size()-1);
                        numbers.remove(numbers.size()-1);
                        numbers.add(0, lastNum);
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int item : numbers) {
            System.out.print(item + " ");
        }
    }
}
