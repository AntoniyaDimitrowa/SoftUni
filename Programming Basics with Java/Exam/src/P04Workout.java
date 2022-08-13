import java.text.DecimalFormat;
import java.util.Scanner;

public class P04Workout {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        double kilometersFirstDay = Double.parseDouble(scanner.nextLine());
        double totalKilometers = kilometersFirstDay;
        double currKilometers = kilometersFirstDay;

        for(int day = 1; day <= days; day++) {
            int increasePercent = Integer.parseInt(scanner.nextLine());
            currKilometers = currKilometers + currKilometers * (increasePercent*0.01);
            totalKilometers += currKilometers;
        }

        if(totalKilometers >= 1000) {
            System.out.printf("You've done a great job running %.0f more kilometers!", Math.ceil(totalKilometers - 1000));
        } else {
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers", Math.ceil(1000 - totalKilometers));
        }
    }
}
