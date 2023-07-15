package entities.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trucks")
public class Truck extends TransportationVehicle {
    public final static String TYPE = "TRUCK";

    @Column(name = "num_of_containers")
    private int numOfContainers;

    public Truck() {}

    public Truck(int numOfContainers, int loadCapacity) {
        super(TYPE,loadCapacity);
        this.numOfContainers = numOfContainers;
    }

    public int getNumOfContainers() {
        return numOfContainers;
    }

    public void setNumOfContainers(int numOfContainers) {
        this.numOfContainers = numOfContainers;
    }
}
