import java.util.Scanner;

public class P19FoodForPets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        double petsFood = Double.parseDouble(scanner.nextLine());
        double totalEatenFood = 0.0;
        double eatenFoodByDog = 0.0;
        double eatenFoodByCat = 0.0;
        double totalEatenBiscuits = 0.0;

        for(int day = 1; day <= days; day++) {
            int eatenDogFood = Integer.parseInt(scanner.nextLine());
            int eatenCatFood = Integer.parseInt(scanner.nextLine());
            eatenFoodByDog += eatenDogFood;
            eatenFoodByCat += eatenCatFood;
            totalEatenFood += (eatenCatFood + eatenDogFood);

            if(day % 3 == 0) {
                totalEatenBiscuits += (0.10 * (eatenCatFood + eatenDogFood));
            }
        }
        System.out.printf("Total eaten biscuits: %dgr.%n", Math.round(totalEatenBiscuits));
        System.out.printf("%.2f%% of the food has been eaten.%n", (totalEatenFood / petsFood) * 100);
        System.out.printf("%.2f%% eaten from the dog.%n", (eatenFoodByDog / totalEatenFood) * 100);
        System.out.printf("%.2f%% eaten from the cat.%n", (eatenFoodByCat / totalEatenFood) * 100);
    }
}
