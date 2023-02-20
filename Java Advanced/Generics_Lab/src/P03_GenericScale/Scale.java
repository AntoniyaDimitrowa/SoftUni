package P03_GenericScale;

public class Scale <T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        int resultOfComparing = this.left.compareTo(this.right);
        if(resultOfComparing == 0) {
            return null;
        } else {
            if(resultOfComparing < 0) {
                return this.right;
            } else {
                return this.left;
            }
        }
    }
}
