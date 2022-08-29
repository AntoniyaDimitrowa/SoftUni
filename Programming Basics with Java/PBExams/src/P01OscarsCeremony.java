import java.util.Scanner;

public class P01OscarsCeremony {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hallRent = Integer.parseInt(scanner.nextLine());
        double statuettes = hallRent - (hallRent * 0.30);
        double catering = statuettes - (statuettes * 0.15);
        double music = 0.5 * catering;
        double result = hallRent + statuettes + catering + music;
        System.out.printf("%.2f", result);
    }
}
