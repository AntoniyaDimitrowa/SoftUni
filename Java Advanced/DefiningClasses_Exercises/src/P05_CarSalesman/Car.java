package P05_CarSalesman;

public class Car {

    private String model;
    private Engine engine;
    private int weight;
    private String color;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getModel()).append(":").append(System.lineSeparator());
        sb.append(this.getEngine().getModel()).append(":").append(System.lineSeparator());
        sb.append("Power: ").append(this.getEngine().getPower()).append(System.lineSeparator());

        if(this.getEngine().getDisplacement() == 0) {
            sb.append("Displacement: n/a").append(System.lineSeparator());
        } else {
            sb.append("Displacement: ").append(this.getEngine().getDisplacement()).append(System.lineSeparator());
        }

        if(this.getEngine().getEfficiency() == null) {
            sb.append("Efficiency: n/a").append(System.lineSeparator());
        } else {
            sb.append("Efficiency: ").append(this.getEngine().getEfficiency()).append(System.lineSeparator());
        }

        if(this.getWeight() == 0) {
            sb.append("Weight: n/a").append(System.lineSeparator());
        } else {
            sb.append("Weight: ").append(this.getWeight()).append(System.lineSeparator());
        }

        if(this.getEngine().getEfficiency() == null) {
            sb.append("Color: n/a").append(System.lineSeparator());
        } else {
            sb.append("Color: ").append(this.getColor()).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
