package P04_WildFarm.animal;

import P04_WildFarm.food.Food;

public abstract class Animal {
    protected String name;
    protected AnimalType type;
    protected Double weight;
    protected int foodEaten;

    public Animal(String name, Double weight, AnimalType type) {
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.foodEaten = 0;
    }

    public abstract void makeSound();
    public void eat(Food food) {
        if(!willEatFood(food)) {
            System.out.printf("%s are not eating this type of food!", this.type);
            return;
        }

        this.foodEaten += food.getQuantity();
    }

    public abstract boolean willEatFood(Food food);
}
