package P03_SpeedRacing;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();
        int linesCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < linesCount; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCostFor1km = Double.parseDouble(input[2]);
            Car currCar = new Car(model, fuelAmount, fuelCostFor1km);
            cars.put(model, currCar);
        }

        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("End")) {
            String model = command[1];
            int amountOfKm = Integer.parseInt(command[2]);
            cars.get(model).canCarMove(amountOfKm);
            command = scanner.nextLine().split("\\s+");
        }

        cars.forEach((k, v) -> v.Print());
    }
}
