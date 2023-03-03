package P04_StackOfStrings;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.data.remove(this.data.size() - 1);
    }

    public String peek() {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

}
