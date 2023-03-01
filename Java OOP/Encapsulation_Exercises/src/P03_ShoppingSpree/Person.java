package P03_ShoppingSpree;

import java.util.ArrayList;
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
        this.name = name;
    }

    private void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {
        hasEnoughMoney(product);
    }

    private void hasEnoughMoney(Product product) {
        if(product.getCost() > this.money) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.getName(), product.getName()));
        }
    }


}
