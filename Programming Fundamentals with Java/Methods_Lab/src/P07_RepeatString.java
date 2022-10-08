import java.util.Scanner;

public class P07_RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        System.out.println(getNewString(word, count));
    }

    public static String getNewString(String word, int count) {
        String newString = "";
        for (int i = 0; i < count; i++) {
            newString += word;
        }
        return newString;
    }
}

