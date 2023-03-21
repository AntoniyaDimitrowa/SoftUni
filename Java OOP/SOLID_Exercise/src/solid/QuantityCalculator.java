package solid;

import solid.products.HasWeight;

public class QuantityCalculator<T extends HasWeight> extends Calculator<T> {

    @Override
    protected double getAsDouble(T hasWeight) {
        return hasWeight.getWeightKilograms();
    }
}
