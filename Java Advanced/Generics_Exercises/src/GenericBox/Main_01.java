package GenericBox;

import java.util.Scanner;

public class Main_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //for String
        int numberOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfLines; i++) {
            String data = scanner.nextLine();
            Box<String> box = new Box<>(data);
            System.out.println(box);
        }

    }
}
