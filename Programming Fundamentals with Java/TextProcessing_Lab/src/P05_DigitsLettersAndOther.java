import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05_DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        List<Character> letters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();
        List<Character> others = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char currChar = text.charAt(i);
            if(Character.isAlphabetic(currChar)) {
                letters.add(currChar);
            } else if(Character.isDigit(currChar)) {
                digits.add(currChar);
            } else {
                others.add(currChar);
            }
        }

        printList("", digits);
        printList("", letters);
        printList("", others);
    }

    public static void printList (String delimiter, List<Character> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + delimiter);
        }
        System.out.println();
    }
}
