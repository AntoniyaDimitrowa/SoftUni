import java.util.Scanner;

public class P02SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int holidays = Integer.parseInt(scanner.nextLine());
        int workingDays = 365 - holidays;
        int minutesCurrYear = (holidays * 127) + (workingDays * 63);
        int differenceFromTheNorm = Math.abs(30000 - minutesCurrYear);
        int differenceHours = differenceFromTheNorm / 60;
        int differenceMinutes = differenceFromTheNorm % 60;

        if(minutesCurrYear > 30000) {
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", differenceHours, differenceMinutes);
        } else {
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", differenceHours, differenceMinutes);
        }
    }
}
