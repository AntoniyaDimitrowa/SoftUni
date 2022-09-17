import java.util.Scanner;

public class P03BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int newTime = hours * 60 + minutes + 30;
        int newHours = newTime / 60;
        if (newHours == 24) {
            newHours = 0;
        }
        int newMinutes = newTime % 60;
        if (newMinutes < 10) {
            System.out.printf("%d:0%d", newHours, newMinutes);
        } else {
            System.out.printf("%d:%d", newHours, newMinutes);
        }
    }
}
