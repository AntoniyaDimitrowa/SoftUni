import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> keyItems = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> junk = new LinkedHashMap<>();
        keyItems.put("shards", 0);
        keyItems.put("fragments", 0);
        keyItems.put("motes", 0);
        String winner = "";

        while (winner.equals("")) {
            String inputLine = scanner.nextLine();
            String inputToLower = inputLine.toLowerCase();
            String[] inputArr = inputToLower.split("\\s+");
            for (int i = 0; i < inputArr.length; i += 2) {
                int currQuantity = Integer.parseInt(inputArr[i]);
                String material = inputArr[i + 1];

                if (material.equals("motes") || material.equals("fragments") || material.equals("shards")) {
                    int totalQuantity = currQuantity + keyItems.get(material);
                    keyItems.put(material, totalQuantity);
                } else {
                    if (junk.containsKey(material)) {
                        int totalQuantity = currQuantity + junk.get(material);
                        junk.put(material, totalQuantity);
                    } else {
                        junk.put(material, currQuantity);
                    }
                }

                if (keyItems.get("motes") >= 250) {
                    winner = "Dragonwrath";
                    System.out.println("Dragonwrath obtained!");
                    int remainingMotes = keyItems.get("motes") - 250;
                    keyItems.put("motes", remainingMotes);
                    break;
                }

                if (keyItems.get("fragments") >= 250) {
                    winner = "Valanyr";
                    System.out.println("Valanyr obtained!");
                    int remainingFragments = keyItems.get("fragments") - 250;
                    keyItems.put("fragments", remainingFragments);
                    break;
                }

                if (keyItems.get("shards") >= 250) {
                    winner = "Shadowmourne";
                    System.out.println("Shadowmourne obtained!");
                    int remainingShards = keyItems.get("shards") - 250;
                    keyItems.put("shards", remainingShards);
                    break;
                }
            }
        }

        System.out.println("shards: " + keyItems.get("shards"));
        System.out.println("fragments: " + keyItems.get("fragments"));
        System.out.println("motes: " + keyItems.get("motes"));

        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
