package P01_CardSuit;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input + ":");
        Arrays.stream(CardSuit.values())
                .forEach(v -> System.out.printf("Ordinal value: %d; Name value: %s%n", v.ordinal(), v.name()));
    }
}
