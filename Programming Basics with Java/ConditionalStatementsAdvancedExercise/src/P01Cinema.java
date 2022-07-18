import java.util.Scanner;

public class P01Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cinoProjectionType = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        int seats = rows * columns;
        double income = 0.0;
        if(cinoProjectionType.equals("Premiere")) {
            income = seats * 12.00;
        } else if(cinoProjectionType.equals("Normal")) {
            income = seats * 7.50;
        } else if(cinoProjectionType.equals("Discount")) {
            income = seats * 5.00;
        }
        System.out.printf("%.2f leva", income);

    }
}
