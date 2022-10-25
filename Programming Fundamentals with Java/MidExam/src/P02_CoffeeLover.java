import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_CoffeeLover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> coffeeList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfCommands; i++) {
            String[] commandArr = scanner.nextLine().split(" ");
            String command = commandArr[0];

            switch (command) {
                case "Include":
                    String coffee = commandArr[1];
                    coffeeList.add(coffee);
                    break;
                case "Remove":
                    int numberOfCoffees = Integer.parseInt(commandArr[2]);
                    if(numberOfCoffees <= coffeeList.size()) {
                        if (commandArr[1].equals("first")) {
                            for (int j = 1; j <= numberOfCoffees; j++) {
                                coffeeList.remove(0);
                            }
                        } else if (commandArr[1].equals("last")) {
                            for (int j = 1; j <= numberOfCoffees; j++) {
                                coffeeList.remove(coffeeList.size()-1);
                            }
                        }
                    }
                    break;
                case "Prefer":
                    int coffeeIndex1 = Integer.parseInt(commandArr[1]);
                    int coffeeIndex2 = Integer.parseInt(commandArr[2]);
                    if(coffeeIndex1 >= 0 && coffeeIndex1 < coffeeList.size() && coffeeIndex2 >= 0 && coffeeIndex2 < coffeeList.size()) {
                        if (coffeeList.contains(coffeeList.get(coffeeIndex1)) && coffeeList.contains(coffeeList.get(coffeeIndex2))) {
                            String coffee1 = coffeeList.get(coffeeIndex1);
                            String coffee2 = coffeeList.get(coffeeIndex2);
                            coffeeList.remove(coffeeIndex1);
                            coffeeList.add(coffeeIndex1, coffee2);
                            coffeeList.remove(coffeeIndex2);
                            coffeeList.add(coffeeIndex2, coffee1);
                        }
                    }
                    break;
                case "Reverse":
                    Collections.reverse(coffeeList);
                    break;
            }
        }

        System.out.println("Coffees:");
        for (int i = 0; i < coffeeList.size(); i++) {
            System.out.print(coffeeList.get(i) + " ");
        }
    }
}
