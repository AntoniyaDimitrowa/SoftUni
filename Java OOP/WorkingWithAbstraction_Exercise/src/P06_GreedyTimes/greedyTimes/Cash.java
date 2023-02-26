package P06_GreedyTimes.greedyTimes;

public class Cash {
    private String name;
    private long quantity;

    public Cash(String name, long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("##%s - %d", this.name, this.quantity);
    }
}
