package P02_Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double perimeter, Double area, Double radius) {
        super(perimeter, area);
        this.radius = radius;
    }
}
