import java.util.Scanner;

public class P02LettersCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLetter = scanner.nextLine();
        String secondLetter = scanner.nextLine();
        String thirdLetter = scanner.nextLine();
        int combinationsCounter = 0;

        for(char i = firstLetter.charAt(0); i <= secondLetter.charAt(0); i++) {
            for(char j = firstLetter.charAt(0); j <= secondLetter.charAt(0); j++) {
                for(char k = firstLetter.charAt(0); k <= secondLetter.charAt(0); k++) {
                    if(i != thirdLetter.charAt(0) && j != thirdLetter.charAt(0) && k != thirdLetter.charAt(0)) {
                        System.out.printf("%s%s%s ", i, j, k);
                        combinationsCounter++;
                    }
                }
            }
        }
        System.out.println(combinationsCounter);


    }
}
