import java.util.Scanner;

public class P05Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double change = Double.parseDouble(scanner.nextLine());
        double changeInCoins = Math.round(change * 100);
        int coinsCount = 0;

        while(changeInCoins > 0) {
            if(changeInCoins >= 200) {
                coinsCount++;
                changeInCoins -= 200;
            } else if(changeInCoins >= 100) {
                coinsCount++;
                changeInCoins -= 100;
            } else if(changeInCoins >= 50) {
                coinsCount++;
                changeInCoins -= 50;
            } else if(changeInCoins >= 20) {
                coinsCount++;
                changeInCoins -= 20;
            } else if(changeInCoins >= 10) {
                coinsCount++;
                changeInCoins -= 10;
            } else if(changeInCoins >= 5) {
                coinsCount++;
                changeInCoins -= 5;
            } else if(changeInCoins >= 2) {
                coinsCount++;
                changeInCoins -= 2;
            } else if(changeInCoins >= 1) {
                coinsCount++;
                changeInCoins -= 1;
            }
        }
        System.out.println(coinsCount);
    }
}
