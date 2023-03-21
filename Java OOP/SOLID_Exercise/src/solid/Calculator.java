package solid;

import java.util.Collection;

public abstract class Calculator<T> {
    public double sum(Iterable<T> values) {
        double sum = 0;

        for (T value : values) {
            sum += getAsDouble(value);
        }

        return sum;
    }

    public double average(Collection<T> values) {
        return sum(values) / values.size();
    }

    protected abstract double getAsDouble(T value);
}
