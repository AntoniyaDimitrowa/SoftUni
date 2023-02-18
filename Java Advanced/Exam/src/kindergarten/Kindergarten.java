package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if(this.registry.size() < this.capacity) {
            this.registry.add(child);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeChild(String firstName) {
        Child child = getChild(firstName);
        if(child == null) {
            return false;
        } else {
            this.registry.remove(child);
            return true;
        }
    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName) {
        for (int i = 0; i < getChildrenCount(); i++) {
            if(this.registry.get(i).getFirstName().equals(firstName)) {
                return this.registry.get(i);
            }
        }
        return null;
    }

    public String registryReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Registered children in ").append(this.name).append(":\n");

        Comparator<Child> comparator = (ch1, ch2) -> {
            int result = Integer.compare(ch1.getAge(), ch2.getAge());
            if(result == 0) {
                result = ch1.getLastName().compareTo(ch2.getLastName());
                if(result == 0) {
                    result = ch1.getFirstName().compareTo(ch2.getFirstName());
                }
            }
            return result;
        };

        this.registry.stream()
                .sorted(comparator)
                .forEach(ch -> {
                    sb.append("--\n");
                    sb.append(ch.toString()).append("\n");
                });
        return sb.toString();
    }
}
