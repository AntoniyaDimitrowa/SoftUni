package P02_VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");
        String[] busInfo = scanner.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));
        Vehicle bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            try {
                String[] commandParts = scanner.nextLine().split("\\s+");
                executeCommand(commandParts, car, truck, bus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static void executeCommand(String[] commandParts, Vehicle car, Vehicle truck, Vehicle bus) {
        String commandName = commandParts[0];
        String vehicleType = commandParts[1];

        switch (commandName) {
            case "Drive":
                double distance = Double.parseDouble(commandParts[2]);
                if(vehicleType.equals("Car")) {
                    System.out.println(car.drive(distance));
                } else if(vehicleType.equals("Truck")) {
                    System.out.println(truck.drive(distance));
                } else if(vehicleType.equals("Bus")) {
                    ((Bus) bus).setEmpty(false);
                    System.out.println(bus.drive(distance));
                }
                break;
            case "Refuel":
                double litters = Double.parseDouble(commandParts[2]);
                if(vehicleType.equals("Car")) {
                    car.refuel(litters);
                } else if(vehicleType.equals("Truck")) {
                    truck.refuel(litters);
                } else if(vehicleType.equals("Bus")) {
                    bus.refuel(litters);
                }
                break;
            case "DriveEmpty":
                double distanceBus = Double.parseDouble(commandParts[2]);
                ((Bus) bus).setEmpty(true);
                System.out.println(bus.drive(distanceBus));
                break;
            default:
                throw new IllegalArgumentException("Invalid command!");
        }
    }
}
