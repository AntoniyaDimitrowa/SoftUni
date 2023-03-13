package P04_WildFarm.animal;

import P04_WildFarm.food.Food;
import P04_WildFarm.food.Meat;
import P04_WildFarm.food.Vegetable;

public class Tiger extends Feline {
    private String livingRegion;

    public Tiger(String name, Double weight, AnimalType type, String region) {
        super(name, weight, type, region);
        this.livingRegion = region;
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public boolean willEatFood(Food food) {
        return food instanceof Meat;
    }
}
