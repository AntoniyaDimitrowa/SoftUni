package P01_Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            executeCommand(commandParts, car, truck);
        }

        System.out.println(car);
        System.out.println(truck);
    }

    private static void executeCommand(String[] commandParts, Vehicle car, Vehicle truck) {
        String commandName = commandParts[0];
        String vehicleType = commandParts[1];

        switch (commandName) {
            case "Drive":
                double distance = Double.parseDouble(commandParts[2]);
                if(vehicleType.equals("Car")) {
                    System.out.println(car.drive(distance));
                } else if(vehicleType.equals("Truck")) {
                    System.out.println(truck.drive(distance));
                }
                break;
            case "Refuel":
                double litters = Double.parseDouble(commandParts[2]);
                if(vehicleType.equals("Car")) {
                    car.refuel(litters);
                } else if(vehicleType.equals("Truck")) {
                    truck.refuel(litters);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid command!");
        }
    }
}
