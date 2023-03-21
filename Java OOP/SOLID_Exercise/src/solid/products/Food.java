package solid.products;

public abstract class Food implements HasWeight {
    private double weightGrams;

    protected Food(double weightGrams) {
        this.weightGrams = weightGrams;
    }

    @Override
    public double getWeightGrams() {
        return weightGrams;
    }

    @Override
    public double getWeightKilograms() {
        return getWeightGrams() / 1000;
    }
}
