import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class P08_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        LinkedHashMap<String, Integer> alphabet = new LinkedHashMap<>();

        char lowerCase = 'a';
        char upperCase = 'A';
        for (int i = 0; i < 26; i++) {
            alphabet.put(upperCase+"", i+1);
            alphabet.put(lowerCase+"", i+1);
            lowerCase++;
            upperCase++;
            if(lowerCase > 'z' && upperCase > 'Z') {
                break;
            }
        }

        double totalSum = 0;
        for (String item : input) {
            String firstLetter =  "" + item.charAt(0);
            String lastLetter = "" + item.charAt(item.length() - 1);
            double num = Double.parseDouble(item.substring(1, item.length() - 1));
            double currRes = 0;

            if(alphabet.containsKey(firstLetter)) {
                if (firstLetter.toLowerCase().equals(firstLetter)) {
                    currRes = num * alphabet.get(firstLetter);
                } else {
                    currRes = num / alphabet.get(firstLetter);
                }
            }

            if(alphabet.containsKey(lastLetter)) {
                if (lastLetter.toLowerCase().equals(lastLetter)) {
                    currRes = currRes + alphabet.get(lastLetter);
                } else {
                    currRes = currRes - alphabet.get(lastLetter);
                }
            }

            totalSum += currRes;
        }
        System.out.printf("%.2f", totalSum);
    }
}
