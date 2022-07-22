import java.util.Scanner;

public class P06TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine();
        double kilometersPerMonth = Double.parseDouble(scanner.nextLine());
        double salary = 0.0;

        if(kilometersPerMonth <= 5000) {
            switch (season) {
                case "Spring":
                case "Autumn":
                    salary = kilometersPerMonth * 0.75 * 4;
                    break;
                case "Summer":
                    salary = kilometersPerMonth * 0.90 * 4;
                    break;
                case "Winter":
                    salary = kilometersPerMonth * 1.05 * 4;
                    break;
            }
        } else if(kilometersPerMonth <= 10000) {
            switch (season) {
                case "Spring":
                case "Autumn":
                    salary = kilometersPerMonth * 0.95 * 4;
                    break;
                case "Summer":
                    salary = kilometersPerMonth * 1.10 * 4;
                    break;
                case "Winter":
                    salary = kilometersPerMonth * 1.25 * 4;
                    break;
            }
        } else if(kilometersPerMonth <= 20000) {
            salary = kilometersPerMonth * 1.45 * 4;
        }

        salary = salary - salary * 0.10;
        System.out.printf("%.2f", salary);

    }
}
