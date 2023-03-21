package solid;

import solid.products.Product;

public class CalorieCalculator extends Calculator<Product> {
    public CalorieCalculator() {
    }

    @Override
    protected double getAsDouble(Product product) {
        return calculateCalories(product.getWeightGrams(), product.getCaloriesPer100Grams());
    }

    private double calculateCalories(double grams, double caloriesPer100Grams) {
        return (caloriesPer100Grams / 100) * grams;
    }
}
