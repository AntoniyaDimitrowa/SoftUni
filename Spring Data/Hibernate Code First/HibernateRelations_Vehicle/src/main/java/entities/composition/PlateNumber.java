package entities.composition;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "plate_numbers")
public class PlateNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String number;

    @OneToOne(targetEntity = CompositionCar.class, mappedBy = "plateNumber")
    private CompositionCar car;

    public PlateNumber(){}
    public PlateNumber(String number) {
        this.number = number;
    }

    public CompositionCar getCar() {
        return car;
    }

    public void setCar(CompositionCar car) {
        this.car = car;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
