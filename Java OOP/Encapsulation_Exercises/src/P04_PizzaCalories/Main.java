package P04_PizzaCalories;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pizzaInfo = scanner.nextLine().split("\\s+");
        String[] doughInfo = scanner.nextLine().split("\\s+");
        List<String> toppingsInfo = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            toppingsInfo.add(command);
            command = scanner.nextLine();
        }

        try {
            Pizza pizza = new Pizza(pizzaInfo[1], Integer.parseInt(pizzaInfo[2]));
            Dough dough = new Dough(doughInfo[1], doughInfo[2], Double.parseDouble(doughInfo[3]));
            pizza.setDough(dough);

            toppingsInfo.forEach(t -> {
                Topping topping = new Topping(t.split("\\s+")[1], Double.parseDouble(t.split("\\s+")[2]));
                pizza.addTopping(topping);
            });

            System.out.printf("%s - %.2f%n", pizzaInfo[1], pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
