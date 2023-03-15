package P01_Vehicles;

public class Truck extends Vehicle {

    private static final double ADDITIONAL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_CONSUMPTION);
    }

    @Override
    public void refuel(double litters) {
        this.fuelQuantity += 0.95 * litters;
    }
}
