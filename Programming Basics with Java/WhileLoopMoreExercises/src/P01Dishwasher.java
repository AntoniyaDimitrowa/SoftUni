import java.util.Scanner;

public class P01Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bottlesOfDetergentCount = Integer.parseInt(scanner.nextLine());
        int detergentInMl = bottlesOfDetergentCount * 750;
        String command = scanner.nextLine();
        int counter = 0;
        int cleanedDishes = 0;
        int cleanedPots = 0;

        while(!command.equals("End")) {
            counter++;
            int dishesForCleaning = Integer.parseInt(command);
            if(counter == 3) {
                detergentInMl = detergentInMl - (dishesForCleaning * 15);
                cleanedPots += dishesForCleaning;
                counter = 0;
            } else {
                detergentInMl = detergentInMl - (dishesForCleaning * 5);
                cleanedDishes += dishesForCleaning;
            }


            if(detergentInMl < 0) {
                System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(detergentInMl));
                break;
            }
            command = scanner.nextLine();
        }
        if(detergentInMl >= 0) {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", cleanedDishes, cleanedPots);
            System.out.printf("Leftover detergent %d ml.", detergentInMl);
        }
    }
}
