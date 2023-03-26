import Exceptions.NumbersException;

import java.util.Scanner;

public class P01_NumberInRange {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split("\\s+");
        int lowerBound = Integer.parseInt(parts[0]);
        int upperBound = Integer.parseInt(parts[1]);
        System.out.printf("Range: [%d...%d]%n", lowerBound, upperBound);

        boolean isValid = false;
        int num = 0;
        while(!isValid) {
            String input = scanner.nextLine();
            try {
                num = parseNumberInRange(input, lowerBound, upperBound);
                isValid = true;
            } catch (NumbersException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Valid number: " + num);

    }

    private static int parseNumberInRange(String input, int lowerBound, int upperBound) {
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumbersException("Invalid number: " + input);
        }

        if(num < lowerBound || num > upperBound) {
            throw new NumbersException("Number " + input + "is out of range!");
        }

        return num;
    }
}
