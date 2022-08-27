import java.util.Scanner;

public class P10Profit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfBGN1Coins = Integer.parseInt(scanner.nextLine());
        int numberOfBGN2Coins = Integer.parseInt(scanner.nextLine());
        int numberOfBGN5Banknotes = Integer.parseInt(scanner.nextLine());
        int sum = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i <= numberOfBGN1Coins; i++) {
            for(int j = 0; j <= numberOfBGN2Coins; j++) {
                for(int k = 0; k <= numberOfBGN5Banknotes; k++) {
                    if(i + (j * 2) + (k * 5) == sum) {
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.%n", i, j, k, sum);
                    }
                }
            }
        }
    }
}
