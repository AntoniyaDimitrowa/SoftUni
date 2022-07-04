import java.util.Scanner;

public class P06Repainting
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int amountOfNylon = Integer.parseInt(scanner.nextLine());
        int amountOfPaint = Integer.parseInt(scanner.nextLine());
        int amountOfPaintThinner = Integer.parseInt(scanner.nextLine());
        int hoursOfWorking = Integer.parseInt(scanner.nextLine());
        double priceForNylon = (amountOfNylon + 2) * 1.50;
        double priceForPaint = (amountOfPaint + amountOfPaint * 0.1) * 14.50;
        double materialsTotalPrice = priceForNylon + priceForPaint + amountOfPaintThinner * 5.0 + 0.4;
        double priceForWorkers = (materialsTotalPrice * 0.3) * hoursOfWorking;
        double finalePrice = materialsTotalPrice + priceForWorkers;
        System.out.println(finalePrice);
    }
}
