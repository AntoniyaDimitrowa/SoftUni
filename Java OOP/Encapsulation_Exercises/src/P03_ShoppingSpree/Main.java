package P03_ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> peoplesInfo = Arrays
                .stream(scanner.nextLine().split(";"))
                .collect(Collectors.toList());

        List<String> productsInfo = Arrays
                .stream(scanner.nextLine().split(";"))
                .collect(Collectors.toList());

        Map<String,Person> people = new LinkedHashMap<>();
        Map<String,Product> products = new LinkedHashMap<>();

        try {
            for (String info : peoplesInfo) {
                String[] infoArr = info.split("=");
                Person person = new Person(infoArr[0], Integer.parseInt(infoArr[1]));
                people.put(infoArr[0], person);
            }

            for (String info : productsInfo) {
                String[] infoArr = info.split("=");
                Product product = new Product(infoArr[0], Integer.parseInt(infoArr[1]));
                products.put(infoArr[0], product);
            }

            String command = scanner.nextLine();
            while (!command.equals("END")) {
                String name = command.split(" ")[0];
                String product = command.split(" ")[1];

                if(products.containsKey(product) && people.containsKey(name)) {
                    Person currPerson = people.get(name);
                    Product currProduct = products.get(product);

                    currPerson.buyProduct(currProduct);
                }

                command = scanner.nextLine();
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        if(people.isEmpty()) {
            return;
        }

        people.entrySet().forEach(e ->  {
            if(e.getValue().getProductsNames().isEmpty()) {
                System.out.println(e.getKey() + " - Nothing bought");
            } else {
                System.out.println(e.getKey() + " - " + String.join(", ", e.getValue().getProductsNames()));
            }
        });
    }
}
