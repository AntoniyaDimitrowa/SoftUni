import java.util.Scanner;

public class P15TheMostPowerfulWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String theMostPowerfulWord = "";
        int powerOfTheMostPowerfulWord = 0;

        while (!word.equals("End of words")) {
            int currWordPower = 0;
            for(int i = 0; i < word.length(); i++) {
                int letterASCII = word.charAt(i);
                currWordPower += letterASCII;
            }
            switch (word.charAt(0)) {
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                case 'y':
                case 'Y':
                    currWordPower *= word.length();
                    break;
                default:
                    currWordPower = currWordPower / word.length();
                    break;
            }
            if(currWordPower > powerOfTheMostPowerfulWord) {
                powerOfTheMostPowerfulWord = currWordPower;
                theMostPowerfulWord = word;
            }
            word = scanner.nextLine();
        }
        System.out.printf("The most powerful word is %s - %d", theMostPowerfulWord, powerOfTheMostPowerfulWord);
    }
}
