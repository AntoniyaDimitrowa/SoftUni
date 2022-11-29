import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plantsCount = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> plantsRarity = new LinkedHashMap<>();
        Map<String, Double> plantsRating = new LinkedHashMap<>();

        for (int i = 0; i < plantsCount; i++) {
            String[] currPlantArr = scanner.nextLine().split("<->");
            String currPlant = currPlantArr[0];
            int currPlantRarity = Integer.parseInt(currPlantArr[1]);

            plantsRarity.put(currPlant, currPlantRarity);
            plantsRating.put(currPlant, 0.00);
        }

        String input = scanner.nextLine();
        input = input.replaceAll("\\s+", "");
        String[] commandArr = input.split("[:-]");
        while (!commandArr[0].equals("Exhibition")) {
            String command = commandArr[0];
            String plantName = commandArr[1];
            switch (command) {
                case "Rate":
                    double plantRating = Double.parseDouble(commandArr[2]);
                    if(plantsRating.containsKey(plantName)) {
                        if(plantsRating.get(plantName) != 0.00) {
                            double oldRating = plantsRating.get(plantName);
                            plantsRating.put(plantName, (plantRating + oldRating) / 2);
                        } else {
                            plantsRating.put(plantName, plantRating);
                        }
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(commandArr[2]);
                    if(plantsRarity.containsKey(plantName)) {
                        plantsRarity.put(plantName, newRarity);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    if(plantsRating.containsKey(plantName)) {
                        plantsRating.put(plantName, 0.00);
                    } else {
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            input = scanner.nextLine().replaceAll("\\s+", "");
            commandArr = input.split("[:-]");
        }

        System.out.println("Plants for the exhibition: ");
        for (Map.Entry<String, Integer> entry : plantsRarity.entrySet()) {
            String plantName = entry.getKey();
            int rarity = entry.getValue();
            double rating = plantsRating.get(plantName);
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", plantName, rarity, rating);
        }
    }
}
