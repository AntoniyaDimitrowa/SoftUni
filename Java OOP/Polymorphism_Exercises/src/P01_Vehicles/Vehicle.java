package P01_Vehicles;

import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption; //fuel consumption in liters per km

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
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
        this.fuelQuantity -= distance * this.fuelConsumption;

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
        this.fuelQuantity += litters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}