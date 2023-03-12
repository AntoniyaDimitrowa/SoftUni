package P03_Animals;

public class Cat extends Animal {
    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    protected String explainSelf() {
        return String.format("%sMEEOW", super.explainSelf());
    }


}
