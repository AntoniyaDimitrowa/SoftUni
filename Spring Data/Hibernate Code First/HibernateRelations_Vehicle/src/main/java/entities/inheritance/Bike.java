package entities.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bikes")
public class Bike extends Vehicle {
    public final static String TYPE = "BIKE";

    public Bike() {
        super(TYPE);
    }
}
