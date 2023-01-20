import java.util.ArrayDeque;
import java.util.Scanner;

public class P07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfOperations = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String[]> operationsHistory = new ArrayDeque<>();
        ArrayDeque<String> deletesHistory = new ArrayDeque<>();

        for (int i = 0; i < numberOfOperations; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            if(command[0].equals("1")) {
                text.append(command[1]);
                operationsHistory.push(command);
            } else if(command[0].equals("2")) {
                int count = Integer.parseInt(command[1]);
                String deleted = text.substring(text.length() - count);
                text.delete(text.length() - count, text.length());
                operationsHistory.push(command);
                deletesHistory.push(deleted);
            } else if(command[0].equals("3")) {
                int index = Integer.parseInt(command[1]);
                char result = text.charAt(index - 1);
                System.out.println(result);
            } else if(command[0].equals("4")) {
                String[] previousOperation = operationsHistory.peek();
                if(previousOperation[0].equals("1")) {
                    int elementsToDelete = previousOperation[1].length();
                    text.delete(text.length() - elementsToDelete, text.length());
                } else if(previousOperation[0].equals("2")) {
                    String elementsToAppend = deletesHistory.pop();
                    text.append(elementsToAppend);
                }
                operationsHistory.pop();
            }
        }
    }
}
