package P04_PizzaCalories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topping {

    enum Type {
        MEAT(1.2),
        VEGGIES(0.8),
        CHEESE(1.1),
        SAUCE(0.9);

        private double value;
        Type(double value) {
            this.value = value;
        }

        double getValue() {
            return this.value;
        }

        static List<String> getTypes() {
            List<Dough.Type> types = Arrays.stream(Dough.Type.values()).toList();
            List<String> typesNames = new ArrayList<>();
            types.forEach(t -> typesNames.add(t.name()));

            return typesNames;
        }
    }
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if(Type.getTypes().contains(toppingType)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories () {
        return (2 * this.weight) * Type.valueOf(this.toppingType.toUpperCase()).getValue();
    }
}
