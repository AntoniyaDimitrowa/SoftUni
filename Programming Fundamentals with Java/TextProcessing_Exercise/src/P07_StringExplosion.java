import java.util.Scanner;

public class P07_StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder result = new StringBuilder(str);
        int totalStrength = 0;
        for (int i = 0; i < result.length(); i++) {
            char currChar = result.charAt(i);
            if(currChar == '>') {
                int strength = Integer.parseInt("" + result.charAt(i+1));
                totalStrength += strength;
            } else if(currChar != '>' && totalStrength > 0) {
                result.deleteCharAt(i);
                totalStrength--;
                i--;
            }
        }

        System.out.println(result);
    }
}
