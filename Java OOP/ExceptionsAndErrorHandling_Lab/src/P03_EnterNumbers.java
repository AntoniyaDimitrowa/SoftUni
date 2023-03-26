import Exceptions.NumbersException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03_EnterNumbers {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int lowerBound = 1;
        int upperBound = 100;
        List<Integer> enteredNumbers = new ArrayList<>();

        while (enteredNumbers.size() < 10) {
            try {
                lowerBound = readNumber(lowerBound, upperBound);
                enteredNumbers.add(lowerBound);
            } catch (NumbersException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(enteredNumbers.toString().replaceAll("[\\[\\]]", ""));
    }

    private static int readNumber(int lowerBound, int upperBound) {
        String input = scanner.nextLine();
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumbersException("Invalid Number!", e);
        }

        if(num <= lowerBound || num >= upperBound) {
            throw new NumbersException(String.format("Your number is not in range (%d - %d)!", lowerBound, upperBound));
        }

        return num;
    }
}
