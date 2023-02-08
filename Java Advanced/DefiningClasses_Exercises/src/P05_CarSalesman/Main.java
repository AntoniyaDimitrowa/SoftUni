package P05_CarSalesman;

import java.util.*;

public class Main {
    public static List<Engine> engines = new ArrayList<>();
    public static Map<String, Car> cars = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linesOfEngines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < linesOfEngines; i++) {
            String[] engineInfo = scanner.nextLine().split("\\s+");
            Engine currEngine = createEngine(engineInfo);
            engines.add(currEngine);
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            Car currCar = createCar(carInfo);
            cars.put(currCar.getModel(), currCar);
        }

        cars.forEach((k, car) -> System.out.print(car.toString()));
    }

    private static Car createCar(String[] carInfo) {
        String model = carInfo[0];
        Engine engine = null;
        for (Engine currEngine : engines) {
            if(currEngine.getModel().equals(carInfo[1])) {
                engine = currEngine;
                break;
            }
        }
        int weight = 0;
        String color = null;

        if(carInfo.length == 4) {
            weight = Integer.parseInt(carInfo[2]);
            color = carInfo[3];
        } else if(carInfo.length == 3) {
            if(Character.isDigit(carInfo[2].charAt(0))) {
                weight = Integer.parseInt(carInfo[2]);
            } else {
                color = carInfo[2];
            }
        }

        return new Car(model, engine, weight, color);
    }

    public static Engine createEngine(String[] engineInfo) {
        String engineModel = engineInfo[0];
        int enginePower = Integer.parseInt(engineInfo[1]);
        int displacement = 0;
        String efficiency = null;

        if(engineInfo.length == 4) {
            displacement = Integer.parseInt(engineInfo[2]);
            efficiency = engineInfo[3];
        } else if(engineInfo.length == 3) {
            if(Character.isDigit(engineInfo[2].charAt(0))) {
                displacement = Integer.parseInt(engineInfo[2]);
            } else {
                efficiency = engineInfo[2];
            }
        }
        return new Engine(engineModel, enginePower, displacement, efficiency);
    }
}
