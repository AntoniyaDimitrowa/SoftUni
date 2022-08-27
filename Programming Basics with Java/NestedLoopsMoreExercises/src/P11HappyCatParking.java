import java.util.Scanner;

public class P11HappyCatParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int daysCount = Integer.parseInt(scanner.nextLine());
        int hoursPerDay = Integer.parseInt(scanner.nextLine());
        double sum = 0.0;
        double totalSum = 0.0;
        for(int day = 1; day <= daysCount; day++) {
            for(int hour = 1; hour <= hoursPerDay; hour++) {
                if(day % 2 == 0 && hour % 2 != 0) {
                    sum = sum + 2.50;
                } else if(day % 2 != 0 && hour % 2 == 0) {
                    sum = sum + 1.25;
                } else {
                    sum = sum + 1.0;
                }
            }
            System.out.printf("Day: %d - %.2f leva%n", day, sum);
            totalSum = totalSum + sum;
            sum = 0.0;
        }
        System.out.printf("Total: %.2f leva", totalSum);
    }
}
