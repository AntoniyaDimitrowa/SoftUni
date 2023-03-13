package P04_WildFarm;

import P04_WildFarm.animal.*;
import P04_WildFarm.food.Food;
import P04_WildFarm.food.FoodType;
import P04_WildFarm.food.Meat;
import P04_WildFarm.food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] animalInput = command.split("\\s+");
            String[] foodInput = scanner.nextLine().split("\\s+");

            Animal animal = createAnimal(animalInput);
            Food food = createFood(foodInput);

            animal.makeSound();
            animal.eat(food);
            animals.add(animal);

            command = scanner.nextLine();
        }

        animals.forEach(a -> System.out.println(a));
    }

    private static Food createFood(String[] foodInput) {
        FoodType type = FoodType.valueOf(foodInput[0]);
        int quantity = Integer.parseInt(foodInput[1]);
        switch (type) {
            case Meat:
                return new Meat(quantity);
            case Vegetable:
                return new Vegetable(quantity);
        }

        return null;
    }

    private static Animal createAnimal(String[] animalInput) {
        AnimalType type = AnimalType.valueOf(animalInput[0]);

        switch (type) {
            case Cat:
                return new Cat(animalInput[1], Double.parseDouble(animalInput[2]), type, animalInput[3], animalInput[4]);
            case Tiger:
                return new Tiger(animalInput[1], Double.parseDouble(animalInput[2]), type, animalInput[3]);
            case Mouse:
                return new Mouse(animalInput[1], Double.parseDouble(animalInput[2]), type, animalInput[3]);
            case Zebra:
                return new Zebra(animalInput[1], Double.parseDouble(animalInput[2]), type, animalInput[3]);
        }

        return null;
    }
}
