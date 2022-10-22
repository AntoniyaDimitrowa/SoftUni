import java.math.BigDecimal;
import java.util.Scanner;

public class P01_GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal quantityFoodInKilograms = new BigDecimal(scanner.nextLine());
        BigDecimal quantityHayInKilograms = new BigDecimal(scanner.nextLine());
        BigDecimal quantityCoverInKilograms = new BigDecimal(scanner.nextLine());
        BigDecimal guineasWeightInKilograms = new BigDecimal(scanner.nextLine());
        boolean isEnough = true;
        for (int i = 1; i < 31; i++) {
            quantityFoodInKilograms = quantityFoodInKilograms.subtract(BigDecimal.valueOf(0.300));
            if(i % 2 == 0) {
                quantityHayInKilograms = quantityHayInKilograms.subtract(quantityFoodInKilograms.multiply(BigDecimal.valueOf(0.05)));
            }
            if(i % 3 == 0) {
                quantityCoverInKilograms = quantityCoverInKilograms.subtract(guineasWeightInKilograms.multiply(BigDecimal.valueOf(1.0/3)));
            }

            if(quantityFoodInKilograms.compareTo(BigDecimal.valueOf(0)) <= 0 || quantityHayInKilograms.compareTo(BigDecimal.valueOf(0)) <= 0 || quantityCoverInKilograms.compareTo(BigDecimal.valueOf(0)) <= 0) {
                isEnough = false;
                break;
            }
        }

        if(isEnough) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", quantityFoodInKilograms, quantityHayInKilograms, quantityCoverInKilograms);
        } else {
            System.out.println("Merry must go to the pet store!");
        }
    }
}
