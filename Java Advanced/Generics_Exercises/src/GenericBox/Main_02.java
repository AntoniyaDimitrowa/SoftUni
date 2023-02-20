package GenericBox;

import java.util.Scanner;

public class Main_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //for Integer
        int numbersCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbersCount; i++) {
            int data = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(data);
            System.out.println(box);
        }
    }
}
