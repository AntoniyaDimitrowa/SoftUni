import java.util.Arrays;
import java.util.Scanner;

public class P09_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        String[] command = scanner.nextLine().split(" ");
        while(!command[0].equals("end")) {
            if(command[0].equals("swap")) {
                int index1 = Integer.parseInt(command[1]);
                int index2 = Integer.parseInt(command[2]);
                int temp = array[index1];
                array[index1] = array[index2];
                array[index2] = temp;
            } else if(command[0].equals("multiply")) {
                int index1 = Integer.parseInt(command[1]);
                int index2 = Integer.parseInt(command[2]);
                array[index1] = array[index1] * array[index2];
            } else if(command[0].equals("decrease")) {
                for (int i = 0; i < array.length; i++) {
                    array[i]--;
                }
            }
            command = scanner.nextLine().split(" ");
        }

        for (int i = 0; i < array.length - 1; i++) {
            System.out.printf("%d, ", array[i]);
        }
        System.out.printf("%d", array[array.length - 1]);
    }
}
