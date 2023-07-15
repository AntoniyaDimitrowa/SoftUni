package entities.composition;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "composition_cars")
public class CompositionCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column
    private String model;

    @Column
    private double price;

    @Column
    private String type;

    @Column
    private int seats;

    @OneToOne
    @JoinColumn(name = "plate_number_id")
    private PlateNumber plateNumber;

    public CompositionCar() {}

    public CompositionCar(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PlateNumber getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(PlateNumber plateNumber) {
        this.plateNumber = plateNumber;
    }
}
