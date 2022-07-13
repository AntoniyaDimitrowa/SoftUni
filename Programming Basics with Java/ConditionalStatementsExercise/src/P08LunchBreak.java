import java.util.Scanner;

public class P08LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String seriesName = scanner.nextLine();
        int episodeDuration = Integer.parseInt(scanner.nextLine());
        int breakDuration = Integer.parseInt(scanner.nextLine());

        double lunchTime = breakDuration / 8.0;
        double doNothingTime = breakDuration / 4.0;
        double timeLeftForSeries = breakDuration - lunchTime - doNothingTime;

        if(episodeDuration<=timeLeftForSeries)
        {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", seriesName, (Math.ceil(timeLeftForSeries - episodeDuration)));
        }
        else
        {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", seriesName, (Math.ceil(episodeDuration- timeLeftForSeries)));
        }
    }
}
