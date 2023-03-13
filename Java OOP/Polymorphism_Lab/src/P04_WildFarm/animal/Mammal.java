package P04_WildFarm.animal;

import java.text.DecimalFormat;
import java.util.Deque;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String name, Double weight, AnimalType type, String livingRegion) {
        super(name, weight, type);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("####.##");
        String formattedWeight = df.format(this.getWeight());

        return String.format("%s[%s, %s, %s, %d]",
                this.getType(),
                this.getName(),
                formattedWeight,
                this.livingRegion,
                this.getFoodEaten());
    }
}
