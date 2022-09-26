import java.util.Scanner;

public class P08_LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        char letterToUpper = Character.toUpperCase(letter);

        if(letterToUpper == letter) {
            System.out.println("upper-case");
        } else {
            System.out.println("lower-case");
        }
    }
}
