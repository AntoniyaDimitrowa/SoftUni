package P03_ShoppingSpree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if(name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if(money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {
        hasEnoughMoney(product);
        System.out.println(this.name + " bought " + product.getName());
        this.products.add(product);
        this.setMoney(this.money - product.getCost());
    }

    private void hasEnoughMoney(Product product) {
        if(product.getCost() > this.money) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.getName(), product.getName()));
        }
    }

    public List<String> getProductsNames() {
        List<String> productsNames = new ArrayList<>();
        this.products.stream()
                .forEach(p -> productsNames.add(p.getName()));
        return Collections.unmodifiableList(productsNames);
    }
}
