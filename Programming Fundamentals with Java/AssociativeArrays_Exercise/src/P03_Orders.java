import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Double> prices = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> quantities = new LinkedHashMap<>();

        String[] command = scanner.nextLine().split("\\s+");
        while(!command[0].equals("buy")) {
            String product = command[0];
            double price = Double.parseDouble(command[1]);
            int currQuantity = Integer.parseInt(command[2]);

            if(prices.containsKey(product)) {
                prices.put(product, price);
                currQuantity = currQuantity + quantities.get(product);
                quantities.put(product, currQuantity);
            } else {
                prices.put(product, price);
                quantities.put(product, currQuantity);
            }
            command = scanner.nextLine().split("\\s+");
        }

        for (Map.Entry<String, Double> price : prices.entrySet()) {
            int quantity = quantities.get(price.getKey());
            double totalPrice = price.getValue() * quantity;
            System.out.printf("%s -> %.2f%n", price.getKey(), totalPrice);
        }
    }
}
