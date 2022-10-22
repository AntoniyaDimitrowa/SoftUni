import java.util.Arrays;
import java.util.Scanner;

public class P02_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] commandArr = scanner.nextLine().split(" ");
        while(!commandArr[0].equals("end")) {
            if(commandArr[0].equals("swap")) {
                int index1 = Integer.parseInt(commandArr[1]);
                int index2 = Integer.parseInt(commandArr[2]);
                int temp = numbers[index1];
                numbers[index1] = numbers[index2];
                numbers[index2] = temp;
            } else if(commandArr[0].equals("multiply")) {
                int index1 = Integer.parseInt(commandArr[1]);
                int index2 = Integer.parseInt(commandArr[2]);
                int result = numbers[index1] * numbers[index2];
                numbers[index1] = result;
            } else if(commandArr[0].equals("decrease")) {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = numbers[i] - 1;
                }
            }
            commandArr = scanner.nextLine().split(" ");
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println(numbers[numbers.length - 1]);
    }
}
