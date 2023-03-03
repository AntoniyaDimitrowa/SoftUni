package P04_PizzaCalories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dough {

    enum Type {
        WHITE(1.5),
        WHOLEGRAIN(1),
        CRISPY(0.9),
        CHEWY(1.1),
        HOMEMADE(1);

        private double value;
        Type(double value) {
            this.value = value;
        }

        double getValue() {
            return this.value;
        }

        static List<String> getTypes() {
            List<Type> types = Arrays.stream(Type.values()).collect(Collectors.toList());
            List<String> typesNames = new ArrayList<>();
            types.forEach(t -> typesNames.add(t.name()));

            return typesNames;
        }
    }
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if(!Type.getTypes().contains(flourType.toUpperCase())) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(!Type.getTypes().contains(bakingTechnique.toUpperCase())) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories () {
        return (2 * this.weight) *
                Type.valueOf(this.flourType.toUpperCase()).getValue() *
                Type.valueOf(this.bakingTechnique.toUpperCase()).getValue();
    }
}
