package P04_RawData;

import java.util.List;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getCarCargoType() {
        return this.getCargo().getType();
    }

    public boolean hasTireWithPressureUnder1() {
        for (Tire tire : this.tires) {
            if(tire.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }

    public boolean hasEnginePowerOver250() {
        if(this.engine.getPower() > 250) {
            return true;
        } else {
            return false;
        }
    }
}
