import java.util.Scanner;

public class P04_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] banList = scanner.nextLine().split(",\\s+");
        String text = scanner.nextLine();

        for (int i = 0; i < banList.length; i++) {
            String banWord = banList[i];
            if(text.contains(banWord)) {
                String replacement = repeatString("*", banWord.length());
                text = text.replace(banWord, replacement);
            }
        }
        System.out.println(text);
    }

    private static String repeatString(String str, int length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            result += str;
        }
        return result;
    }
}
