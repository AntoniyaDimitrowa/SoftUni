package solid.products;

public class Chips extends Food implements Product {
    public static final double CALORIES_PER_100_GRAMS = 529;

    public double weightGrams;

    public Chips(double weightGrams) {
        super(weightGrams);
    }

    @Override
    public double getCaloriesPer100Grams() {
        return CALORIES_PER_100_GRAMS;
    }
}
