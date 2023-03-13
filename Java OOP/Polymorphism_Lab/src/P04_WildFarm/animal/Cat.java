package P04_WildFarm.animal;

import P04_WildFarm.food.Food;

import java.text.DecimalFormat;

public class Cat extends Feline {
    private String breed;

    public Cat(String name, Double weight, AnimalType type, String livingRegion, String breed) {
        super(name, weight, type, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public boolean willEatFood(Food food) {
        return true;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("####.##");
        String formattedWeight = df.format(this.getWeight());

        return String.format("%s[%s, %s, %s, %s, %d]",
                this.getType(),
                this.getName(),
                this.breed,
                formattedWeight,
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
