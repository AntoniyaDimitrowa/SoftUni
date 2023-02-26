package P06_GreedyTimes.greedyTimes;

public class Gold {
    private String name;
    private long quantity;

    public Gold(String name, long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("##%s - %d", this.name, this.quantity);
    }
}
