package P04_WildFarm.animal;

import P04_WildFarm.food.Food;
import P04_WildFarm.food.Vegetable;

public class Mouse extends Mammal {
    public Mouse(String name, Double weight, AnimalType type, String livingRegion) {
        super(name, weight, type, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public boolean willEatFood(Food food) {
        return food instanceof Vegetable;
    }
}
