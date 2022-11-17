import java.util.Scanner;

public class P02_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        int result = characterMultiplier(strings[0], strings[1]);
        System.out.println(result);
    }

    public static int characterMultiplier(String str1, String str2) {
        int totalSum = 0;
        if(str1.length() == str2.length()) {
            for (int i = 0; i < str2.length(); i++) {
                int currChar1 = str1.charAt(i);
                int currChar2 = str2.charAt(i);
                totalSum += (currChar1 * currChar2);
            }
        } else if(str1.length() < str2.length()) {
            int currIndex = 0;
            for (int i = 0; i < str1.length(); i++) {
                int currChar1 = str1.charAt(i);
                int currChar2 = str2.charAt(i);
                totalSum += (currChar1 * currChar2);
                currIndex = i;
            }
            for (int i = currIndex+1; i < str2.length(); i++) {
                totalSum += str2.charAt(i);
            }
        } else {
            int currIndex = 0;
            for (int i = 0; i < str2.length(); i++) {
                int currChar1 = str1.charAt(i);
                int currChar2 = str2.charAt(i);
                totalSum += (currChar1 * currChar2);
                currIndex = i;
            }
            for (int i = currIndex+1; i < str1.length(); i++) {
                totalSum += str1.charAt(i);
            }
        }
        return totalSum;
    }
}
