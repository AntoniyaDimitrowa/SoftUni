package P02_Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public Shape(Double perimeter, Double area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public double calculatePerimeter();
}
