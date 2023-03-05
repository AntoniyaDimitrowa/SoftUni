package P06_Animals;

import P06_Animals.animals.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animalType = scanner.nextLine();
        while (!animalType.equals("Beast!")) {
            String[] animalInfo = scanner.nextLine().split("\\s+");
            try {
                switch (animalType) {
                    case "Dog":
                        Dog dog = new Dog(animalInfo[0], Integer.parseInt(animalInfo[1]), animalInfo[2]);
                        System.out.println(dog.toString());
                        break;
                    case "Cat":
                        Cat cat = new Cat(animalInfo[0], Integer.parseInt(animalInfo[1]), animalInfo[2]);
                        System.out.println(cat.toString());
                        break;
                    case "Frog":
                        Frog frog = new Frog(animalInfo[0], Integer.parseInt(animalInfo[1]), animalInfo[2]);
                        System.out.println(frog.toString());
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(animalInfo[0], Integer.parseInt(animalInfo[1]));
                        System.out.println(kitten.toString());
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(animalInfo[0], Integer.parseInt(animalInfo[1]));
                        System.out.println(tomcat.toString());
                        break;
                    default:
                        throw new IllegalStateException("Unknown animal: " + animalType);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }

            animalType = scanner.nextLine();
        }
    }
}
