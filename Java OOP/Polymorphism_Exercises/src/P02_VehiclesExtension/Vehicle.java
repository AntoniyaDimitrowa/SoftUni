package P02_VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption; //fuel consumption in liters per km
    private final double tankCapacity;


    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.tankCapacity = tankCapacity;
    }

    /**
    *This method is used to decrease the fuelQuantity, if there is enough fuel for the travel, and returns the corresponding message
    *@param distance the distance that the vehicle has to drive
    *@return String  returns the right message - has enough fuel: "{Vehicle type} travelled {distance} km"
                                               - doesn't have enough fuel: "{Vehicle type} needs refueling"
     **/
    public String drive(double distance) {
        if(!checkIfHasEnoughFuel(distance)) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        this.setFuelQuantity(this.fuelQuantity - (distance * this.fuelConsumption));

        DecimalFormat df = new DecimalFormat("####.##");
        String formattedDistance = df.format(distance);
        return this.getClass().getSimpleName() + " travelled " + formattedDistance + " km";
    }

    /**
     *This method is used to check if there is enough fuel for the travel and returns boolean
     *@param distance the distance that the vehicle has to drive
     *@return boolean
     **/
    private boolean checkIfHasEnoughFuel(double distance) {
        if(distance * this.fuelConsumption <= this.fuelQuantity) {
            return true;
        }
        return false;
    }

    /**
     *This method is used to increase the fuelQuantity by the given litters of fuel
     *@param litters the litters of fuel
     **/
    public void refuel(double litters) {
        if(litters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if(this.fuelQuantity + litters > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.setFuelQuantity(this.fuelQuantity + litters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if(fuelQuantity < 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected double getTankCapacity() {
        return tankCapacity;
    }
}
