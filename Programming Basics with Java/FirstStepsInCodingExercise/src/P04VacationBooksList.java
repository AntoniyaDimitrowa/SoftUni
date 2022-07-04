import java.util.Scanner;

public class P04VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pagesInCurrBook = Integer.parseInt(scanner.nextLine());
        int pagesForOneHour = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int hoursForReadingPerDay = (pagesInCurrBook / pagesForOneHour) / days;
        System.out.println(hoursForReadingPerDay);
    }
}
