package P04_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            Car currCar = createCar(info);
            cars.add(currCar);
        }

        String command = scanner.nextLine();
        if(command.equals("fragile")) {
            cars.stream()
                    .filter(car -> car.getCarCargoType().equals("fragile"))
                    .filter(car -> car.hasTireWithPressureUnder1())
                    .forEach(car -> System.out.println(car.getModel()));

        } else if(command.equals("flamable")) {
            cars.stream()
                    .filter(car -> car.getCarCargoType().equals("flamable"))
                    .filter(car -> car.hasEnginePowerOver250())
                    .forEach(car -> System.out.println(car.getModel()));
        }
    }

    public static Car createCar(String[] info) {
        String model = info[0];

        int engineSpeed = Integer.parseInt(info[1]);
        int enginePower = Integer.parseInt(info[2]);
        Engine engine = new Engine(engineSpeed, enginePower);

        int cargoWeight = Integer.parseInt(info[3]);
        String cargoType = info[4];
        Cargo cargo = new Cargo(cargoWeight, cargoType);

        List<Tire> tires = new ArrayList<>();
        for (int i = 5; i < 12; i++) {
            double tirePressure = Double.parseDouble(info[i]);
            int tireAge = Integer.parseInt(info[++i]);
            Tire tire = new Tire(tirePressure, tireAge);
            tires.add(tire);
        }

        return new Car(model, engine, cargo, tires);
    }
}
