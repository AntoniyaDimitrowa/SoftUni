package P06_GreedyTimes.greedyTimes;

public class Gem {
    private String name;
    private long quantity;

    public Gem(String name, long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("##%s - %d", this.name, this.quantity);
    }
}
