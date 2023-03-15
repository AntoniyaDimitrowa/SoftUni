package P02_VehiclesExtension;

public class Bus extends Vehicle {
    private static final double ADDITIONAL_CONSUMPTION = 1.4;

    private boolean isEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.isEmpty = true;
    }

    public void setEmpty(boolean empty) {
        if (this.isEmpty == empty) {
            return;
        } else {
            this.isEmpty = empty;
        }

        if (!this.isEmpty) {
            super.setFuelConsumption(super.getFuelConsumption() + ADDITIONAL_CONSUMPTION);
        }
    }
}
