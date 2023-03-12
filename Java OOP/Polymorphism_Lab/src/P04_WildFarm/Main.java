package P04_WildFarm;

import P04_WildFarm.animal.*;
import P04_WildFarm.food.Food;
import P04_WildFarm.food.FoodType;
import P04_WildFarm.food.Meat;
import P04_WildFarm.food.Vegetable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] animalInput = scanner.nextLine().split("\\s+");
            String[] foodInput = scanner.nextLine().split("\\s+");

            Animal animal = createAnimal(animalInput);
            Food food = createFood(foodInput);

            animal.makeSound();
            animal.eat(food);
            System.out.println(animal);

            command = scanner.nextLine();
        }
    }

    private static Food createFood(String[] foodInput) {
        FoodType type = FoodType.valueOf(foodInput[0].toUpperCase());
        int quantity = Integer.parseInt(foodInput[1]);
        switch (type) {
            case MEAT:
                return new Meat(quantity);
            case VEGETABLE:
                return new Vegetable(quantity);
        }

        return null;
    }

    private static Animal createAnimal(String[] animalInput) {
        AnimalType type = AnimalType.valueOf(animalInput[0].toUpperCase());

        switch (type) {
            case CAT:
                return new Cat(animalInput[1], Double.parseDouble(animalInput[2]), type, animalInput[3], animalInput[4]);
            case TIGER:
                return new Tiger(animalInput[1], Double.parseDouble(animalInput[2]), type, animalInput[3]);
            case MOUSE:
                return new Mouse(animalInput[1], Double.parseDouble(animalInput[2]), type, animalInput[3]);
            case ZEBRA:
                return new Zebra(animalInput[1], Double.parseDouble(animalInput[2]), type, animalInput[3]);
        }

        return null;
    }
}
