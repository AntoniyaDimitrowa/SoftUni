package P01_CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsepower;

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }
    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public Car() {
        this.brand = null;
        this.model = null;
        this.horsepower = 0;
    }
    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsepower = -1;
    }

    public Car(String brand, String model, int horsepower) {
        this.brand = brand;
        this.model = model;
        this.horsepower = horsepower;

    }

    /*
    @Override
    public int hashCode() {
        return this.getBrand().length() + this.getModel().length() + this.getHorsepower();
    }

    @Override
    public boolean equals(Object obj) {

    }*/

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsepower());
    }

    public String carInfo() {
        return this.toString();
    }
}
