package entities.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "planes")
@DiscriminatorValue("PLANE")
public class Plane extends PassengerVehicle {
    public final static String TYPE = "PLANE";

    @Column(name = "passenger_capacity")
    private Integer passengerCapacity;

    public Plane() {}

    public Plane(int passengerCapacity, int loadCapacity) {
        super(TYPE,loadCapacity);
        this.passengerCapacity = passengerCapacity;
    }
}
