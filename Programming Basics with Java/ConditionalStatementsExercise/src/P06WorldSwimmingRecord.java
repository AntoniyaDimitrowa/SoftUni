import java.util.Scanner;

public class P06WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double recordInSeconds = Double.parseDouble(scanner.nextLine());
        double distanceInMeters = Double.parseDouble(scanner.nextLine());
        double secondsForDistanceOfOneMeter = Double.parseDouble(scanner.nextLine());

        double result = distanceInMeters * secondsForDistanceOfOneMeter + ((Math.floor(distanceInMeters/15) * 12.5));

        if(recordInSeconds > result) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", result);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", result - recordInSeconds);
        }

    }
}
