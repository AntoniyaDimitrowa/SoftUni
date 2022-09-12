import java.util.Scanner;

public class P18CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dogFoodInKilograms = Integer.parseInt(scanner.nextLine());
        int dogFoodInGrams = dogFoodInKilograms * 1000;
        String command = scanner.nextLine();

        while(!command.equals("Adopted")) {
            int eatenFood = Integer.parseInt(command);
            dogFoodInGrams = dogFoodInGrams - eatenFood;
            command = scanner.nextLine();
        }
        if(dogFoodInGrams < 0) {
            System.out.printf("Food is not enough. You need %d grams more.", Math.abs(dogFoodInGrams));
        } else {
            System.out.printf("Food is enough! Leftovers: %d grams.", dogFoodInGrams);
        }
    }
}
