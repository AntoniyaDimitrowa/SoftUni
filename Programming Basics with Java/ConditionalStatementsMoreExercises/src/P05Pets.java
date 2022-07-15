import java.util.Scanner;

public class P05Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int daysCount = Integer.parseInt(scanner.nextLine());
        int kilosFoodLeft = Integer.parseInt(scanner.nextLine());
        double foodPerDayDogInKG = Double.parseDouble(scanner.nextLine());
        double foodPerDayCatInKG = Double.parseDouble(scanner.nextLine());
        double foodPerDayTurtleInG = Double.parseDouble(scanner.nextLine());
        double foodPerDayTurtleInKG = foodPerDayTurtleInG / 1000;

        double neededFoodForDog = foodPerDayDogInKG * daysCount;
        double neededFoodForCat = foodPerDayCatInKG * daysCount;
        double neededFoodForTurtle = foodPerDayTurtleInKG * daysCount;
        double totalNeededFood = neededFoodForCat + neededFoodForDog + neededFoodForTurtle;

        if(totalNeededFood > kilosFoodLeft) {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(totalNeededFood - kilosFoodLeft));
        } else {
            System.out.printf("%.0f kilos of food left.", Math.floor(kilosFoodLeft - totalNeededFood));
        }
    }
}
