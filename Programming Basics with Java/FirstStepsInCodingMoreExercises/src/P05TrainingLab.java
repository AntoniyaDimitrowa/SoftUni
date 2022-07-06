import java.util.Scanner;

public class P05TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double widthInMeters = Double.parseDouble(scanner.nextLine());
        double lengthInMeters = Double.parseDouble(scanner.nextLine());

        double lengthInCMWithoutHallway = (lengthInMeters * 100) - 100;
        double  widthInCM = widthInMeters * 100;
        int seatsInOneRow = (int)(lengthInCMWithoutHallway / 70);
        int rows = (int)(widthInCM / 120);
        int totalSeats = (seatsInOneRow * rows) - 3;

        System.out.println(totalSeats);
    }
}
