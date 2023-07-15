package entities.inheritance;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
@DiscriminatorValue("CAR")
public class Car extends PassengerVehicle {
    public final static String TYPE = "CAR";

    @Basic
    private Integer seats;

    public Car() { }

    public Car(String type,int numOfPassengers){
        super(TYPE, numOfPassengers);
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
