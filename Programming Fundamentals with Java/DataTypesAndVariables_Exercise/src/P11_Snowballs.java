import java.math.BigInteger;
import java.util.Scanner;

public class P11_Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int snowballsCount = Integer.parseInt(scanner.nextLine());
        long highestSnowballValue = Long.MIN_VALUE;
        int highestSnowballSnow = Integer.MIN_VALUE;
        int highestSnowballTime = Integer.MIN_VALUE;
        int highestSnowballQuality = Integer.MIN_VALUE;
        for(int i = 1; i <= snowballsCount; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            long snowballValue = (long) Math.pow((snowballSnow * 1.0 / snowballTime), snowballQuality);
            if (snowballValue > highestSnowballValue) {
                highestSnowballValue = snowballValue;
                highestSnowballSnow = snowballSnow;
                highestSnowballTime = snowballTime;
                highestSnowballQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %d (%d)", highestSnowballSnow, highestSnowballTime, highestSnowballValue, highestSnowballQuality);
    }
}
