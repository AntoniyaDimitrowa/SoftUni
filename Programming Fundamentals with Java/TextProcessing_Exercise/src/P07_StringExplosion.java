import java.util.Scanner;

public class P07_StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        result.append(str);

        for (int i = 1; i < result.length(); i++) {
            char currChar = result.charAt(i-1);
            if(currChar == '>') {
                int strength = Integer.parseInt("" + result.charAt(i));
                for (int j = i; j <= strength; j++) {
                    if(result.charAt(j) != '>') {
                        result.replace(j,j,"");
                    } else {
                        strength += Integer.parseInt("" + result.charAt(j+1));
                    }
                }
            }
        }
    }
}
