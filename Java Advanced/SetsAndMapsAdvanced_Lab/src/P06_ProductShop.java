import java.util.*;

public class P06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> stores = new TreeMap<>();
        String[] command = scanner.nextLine().split(",\\s+");
        while (!command[0].equals("Revision")) {
            String storeName = command[0];
            String product = command[1];
            double price = Double.parseDouble(command[2]);
            if(stores.containsKey(storeName)) {
                Map<String, Double> products = stores.get(storeName);
                products.put(product, price);
                stores.put(storeName, products);
            } else {
                Map<String, Double> products = new LinkedHashMap<>();
                products.put(product, price);
                stores.put(storeName, products);
            }
            command = scanner.nextLine().split(",\\s+");
        }
        for (Map.Entry<String, Map<String, Double>> entry : stores.entrySet()) {
            String storeName = entry.getKey();
            Map<String, Double> products = entry.getValue();
            System.out.println(storeName + "->");
            for (Map.Entry<String, Double> entry2 : products.entrySet()) {
                String product = entry2.getKey();
                Double price = entry2.getValue();
                System.out.printf("Product: %s, Price: %.1f%n", product, price);
            }
        }
    }
}
