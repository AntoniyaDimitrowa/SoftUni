import java.util.Scanner;

public class P05GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int moves = Integer.parseInt(scanner.nextLine());

        double result = 0.0;
        int firstGroup = 0;
        int secondGroup = 0;
        int thirdGroup = 0;
        int fourthGroup = 0;
        int fifthGroup = 0;
        int invalidNum = 0;


        for(int i = 1; i <= moves; i++) {
            double number = Double.parseDouble(scanner.nextLine());
            if(number >= 0 && number < 10) {
                firstGroup++;
                result = result + 0.20 * number;
            } else if(number >= 0 && number < 20) {
                secondGroup++;
                result = result + 0.30 * number;
            } else if(number >= 0 && number < 30) {
                thirdGroup++;
                result = result + 0.40 * number;
            } else if(number >= 0 && number < 40) {
                fourthGroup++;
                result = result + 50;
            } else if(number >= 0 && number < 51) {
                fifthGroup++;
                result = result + 100;
            } else {
                invalidNum++;
            }

        }

        double firstGroupPercent = ((firstGroup * 1.0) / moves) * 100;
        double secondGroupPercent = ((secondGroup * 1.0) / moves) * 100;
        double thirdGroupPercent = ((thirdGroup * 1.0) / moves) * 100;
        double fourthGroupPercent = ((fourthGroup * 1.0) / moves) * 100;
        double fifthGroupPercent = ((fifthGroup * 1.0) / moves) * 100;
        double invalidNumbersPercent = ((invalidNum * 1.0) / moves) * 100;
        
    }
}
