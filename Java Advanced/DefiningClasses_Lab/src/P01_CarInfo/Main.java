package P01_CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Car firstCar = new Car();
        //Car secondCar = new Car();

        //firstCar.setBrand("Opel");
        //firstCar.setModel("Astra");
        //firstCar.setHorsepower(90);

        //System.out.printf("The car is: %s %s - %d HP", firstCar.getBrand(), firstCar.getModel(), firstCar.getHorsepower());

        List<Car> carsList = new ArrayList<>();
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            if(info.length == 1) {
                Car currCar = new Car(info[0]);
                carsList.add(currCar);
            } else if(info.length == 3) {
                Car currCar = new Car(info[0], info[1], Integer.parseInt(info[2]));
                carsList.add(currCar);
            }
        }

        carsList.forEach(car -> System.out.println(car.carInfo()));
    }
}
