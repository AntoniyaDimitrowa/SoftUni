package P03_SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private int distanceTraveled;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostFor1Kilometer() {
        return fuelCostFor1km;
    }

    public void setFuelCostFor1Kilometer(double fuelCostFor1Kilometer) {
        this.fuelCostFor1km = fuelCostFor1Kilometer;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public Car(String model, double fuelAmount, double fuelCostFor1Kilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1Kilometer;
        this.distanceTraveled = 0;
    }

    public void canCarMove (int amountOfKm) {
        double kmCanMove = this.fuelAmount / this.fuelCostFor1km;

        if(kmCanMove >= amountOfKm) {
            this.distanceTraveled += amountOfKm;
            this.fuelAmount -= (amountOfKm * this.fuelCostFor1km);
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public void Print() {
        System.out.printf("%s %.2f %d%n", this.getModel(), this.getFuelAmount(), this.distanceTraveled);
    }
}
