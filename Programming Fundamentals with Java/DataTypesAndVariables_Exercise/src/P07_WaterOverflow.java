import java.util.Scanner;

public class P07_WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = 255;
        int lines = Integer.parseInt(scanner.nextLine());
        int myTank = 0;
        for (int i = 0; i < lines; i++) {
            int quantitiesOfWatter = Integer.parseInt(scanner.nextLine());
            if(quantitiesOfWatter > capacity) {
                System.out.println("Insufficient capacity!");
                continue;
            }
            myTank += quantitiesOfWatter;
            capacity -= quantitiesOfWatter;
        }
        System.out.println(myTank);
    }
}
