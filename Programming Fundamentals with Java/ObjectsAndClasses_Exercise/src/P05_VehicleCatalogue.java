import javax.lang.model.util.AbstractElementVisitor14;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05_VehicleCatalogue {
    static class VehicleCatalogue {
        private String typeOfVehicle;
        private String model;
        private String color;
        private int horsepower;

        public String getTypeOfVehicle() {
            return this.typeOfVehicle;
        }
        public void setTypeOfVehicle(String typeOfVehicle) {
            this.typeOfVehicle = typeOfVehicle;
        }
        public String getColor() {
            return this.color;
        }
        public void setColor(String color) {this.color = color;}
        public String getModel() {
            return this.model;
        }
        public void setModel(String model) {this.model = model;}
        public int getHorsepower() {return this.horsepower;}
        public void setHorsepower(int horsepower) {this.horsepower = horsepower;}

        public VehicleCatalogue(String typeOfVehicle, String model, String color, int horsepower) {
            this.typeOfVehicle = typeOfVehicle;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String toString() {
            String result = "Type: " + getTypeOfVehicle() + "%n" + "Model: " + getModel() + "%n" + "Color: " + getColor() + "%n" + "Horsepower: " + getHorsepower() + "%n";
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        int carsCounter = 0;
        int sumHorsepowerCars = 0;
        int trucksCounter = 0;
        int sumHorsepowerTrucks = 0;
        List<VehicleCatalogue> list = new ArrayList<>();

        while (!inputLine.equals("End")) {
            String[] informationArr = inputLine.split(" ");
            String typeOfVehicle = informationArr[0];
            String model = informationArr[1];
            String color = informationArr[2];
            int horsepower = Integer.parseInt(informationArr[3]);

            if(typeOfVehicle.equals("car")) {
                carsCounter++;
                sumHorsepowerCars += horsepower;
            } else if(typeOfVehicle.equals("truck")) {
                trucksCounter++;
                sumHorsepowerTrucks += horsepower;
            }
            VehicleCatalogue currVC = new VehicleCatalogue(typeOfVehicle, model, color, horsepower);
            list.add(currVC);
            inputLine = scanner.nextLine();
        }

        double averageCars = (sumHorsepowerCars * 1.0) / carsCounter;
        double averageTrucks = (sumHorsepowerTrucks * 1.0) / trucksCounter;
        String wantedModel = scanner.nextLine();
        while(!wantedModel.equals("Close the Catalogue")) {
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).model.equals(wantedModel)){
                    list.get(i).toString();
                }
            }
            wantedModel = scanner.nextLine();
        }
    }
}
