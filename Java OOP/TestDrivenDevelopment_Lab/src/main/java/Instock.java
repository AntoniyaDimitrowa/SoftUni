import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private final List<Product> data;

    public Instock() {
        this.data = new ArrayList<>();
    }

    public Iterable<Product> getIterable() {
        return this.data;
    }

    @Override
    public int getCount() {
        return this.data.size();
        //throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Product product) {
        return this.data.contains(product);
        //throw new UnsupportedOperationException();
    }

    @Override
    public void add(Product product) {
        if(!this.data.contains(product)) {
            this.data.add(product);
        }
        //throw new UnsupportedOperationException();
    }

    @Override
    public void changeQuantity(String label, int quantity) {
        Product product = this.findByLabel(label);

        product.setQuantity(product.getQuantity() + quantity);
    }

    @Override
    public Product find(int index) {
        return this.data.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        Optional<Product> maybeProduct = this.data
                .stream()
                .filter(p -> p.getLabel().equals(label))
                .findFirst();

        if(maybeProduct.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return maybeProduct.get();
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if(count > this.getCount()) {
            return new ArrayList<>();
        }

        return this.data
                .stream()
                .sorted(Product::compareTo)
                .limit(count)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        List<Product> productsInRange = this.data
                .stream()
                .sorted((l, r) -> Double.compare(r.getPrice(), l.getPrice()))
                .filter(p -> (p.getPrice() > lo && p.getPrice() <= hi))
                .collect(Collectors.toUnmodifiableList());

        if(productsInRange.isEmpty()) {
            return new ArrayList<>();
        }

        return productsInRange;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        List<Product> productsWhitThatPrice = this.data
                .stream()
                .filter(p -> (p.getPrice() == price))
                .collect(Collectors.toUnmodifiableList());

        if(productsWhitThatPrice.isEmpty()) {
            return new ArrayList<>();
        }

        return productsWhitThatPrice;
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        List<Product> productsWhitThatQuantity = this.data
                .stream()
                .filter(p -> (p.getQuantity() == quantity))
                .collect(Collectors.toUnmodifiableList());

        if(productsWhitThatQuantity.isEmpty()) {
            return new ArrayList<>();
        }

        return productsWhitThatQuantity;
    }

    @Override
    public Iterator<Product> iterator() {
        throw new UnsupportedOperationException();
    }
}
