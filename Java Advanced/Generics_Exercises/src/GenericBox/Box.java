package GenericBox;

public class Box <T extends Comparable<T>> implements Comparable<Box<T>> {

    private T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.data.getClass().getName(), String.valueOf(data));
    }

    @Override
    public int compareTo(Box<T> b) {
        return this.data.compareTo(b.data);
    }
}
