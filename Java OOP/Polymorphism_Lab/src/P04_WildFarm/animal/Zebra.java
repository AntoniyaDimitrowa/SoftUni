package P04_WildFarm.animal;

import P04_WildFarm.food.Food;

public class Zebra extends Mammal {
    public Zebra(String name, Double weight, AnimalType type, String livingRegion) {
        super(name, weight, type, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public boolean willEatFood(Food food) {
        return false;
    }
}
