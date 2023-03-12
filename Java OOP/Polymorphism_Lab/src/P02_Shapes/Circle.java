package P02_Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
        calculateArea();
        calculatePerimeter();
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * this.radius * Math.PI);
    }

    @Override
    protected void calculateArea() {
        setArea(radius * radius * Math.PI);
    }
}
