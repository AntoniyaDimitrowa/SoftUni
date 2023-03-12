package P04_WildFarm.animal;

public abstract class Mammal extends Animal {
    protected String livingRegion;

    public Mammal(String name, Double weight, AnimalType type, String livingRegion) {
        super(name, weight, type);
        this.livingRegion = livingRegion;
    }
}
