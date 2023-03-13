package P04_WildFarm.animal;

import P04_WildFarm.food.Food;

public abstract class Animal {
    private String name;
    private AnimalType type;
    private Double weight;
    private int foodEaten;

    public Animal(String name, Double weight, AnimalType type) {
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.foodEaten = 0;
    }

    protected String getName() {
        return name;
    }

    protected AnimalType getType() {
        return type;
    }

    protected Double getWeight() {
        return weight;
    }

    protected int getFoodEaten() {
        return foodEaten;
    }

    public abstract void makeSound();
    public void eat(Food food) {
        if(!willEatFood(food)) {
            String pluralType = this.type.name();
            if(this.type.name().equals("Mouse")) {
                pluralType = "Mice";
            } else {
                pluralType += "s";
            }
            System.out.printf("%s are not eating that type of food!%n", pluralType);
            return;
        }

        this.foodEaten += food.getQuantity();
    }

    public abstract boolean willEatFood(Food food);
}
