package P04_WildFarm.animal;

import P04_WildFarm.food.Food;

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
        return false;
    }
}
