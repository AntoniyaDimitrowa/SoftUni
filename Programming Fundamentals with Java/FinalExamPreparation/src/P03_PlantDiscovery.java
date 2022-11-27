import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plantsCount = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> plantsRarity = new LinkedHashMap<>();
        Map<String, Integer> plantsRating = new LinkedHashMap<>();

        for (int i = 0; i < plantsCount; i++) {
            String[] currPlantArr = scanner.nextLine().split("<->");
            String currPlant = currPlantArr[0];
            int currPlantRarity = Integer.parseInt(currPlantArr[1]);

            plantsRarity.put(currPlant, currPlantRarity);
        }
        String input = scanner.nextLine();
        input = input.replaceAll("\\s+", "");
        String[] commandArr = input.split("[:-]");
        while (!commandArr[0].equals("Exhibition")) {
            String command = commandArr[0];
            switch (command) {
                case "Rate":
                    String plantName = commandArr[1];
                    double plantRating = Double.parseDouble(commandArr[2]);

                    
                    break;
            }
            commandArr = scanner.nextLine().split("[:\\s+-]]");
        }
    }
}
