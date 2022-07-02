import java.util.Scanner;

public class P09YardGreening
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner((System.in));

        double allSqMeters = Double.parseDouble(scanner.nextLine());

        double amount = allSqMeters * 7.61;
        double discount = amount * 0.18;
        double sumWithDiscount = amount - discount;

        System.out.printf("The final price is: %.2f lv.%n",sumWithDiscount);
        System.out.printf("The discount is: %.2f lv.",discount);
    }
}



