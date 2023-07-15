package entities.inheritance;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PassengerVehicle extends Vehicle {
    @Column(name = "num_of_passengers")
    private int numOfPassengers;
    protected PassengerVehicle() { }
    protected PassengerVehicle(String type,int numOfPassengers) {
        super(type);
        this.numOfPassengers = numOfPassengers;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }
}
