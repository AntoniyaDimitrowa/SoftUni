package P02_PointInRectangle;

public class Rectangle {

    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains (Point point) {
        int pointX = point.getX();
        int pointY = point.getY();

        if(pointX >= this.bottomLeft.getX() && pointX <= this.topRight.getX()
        && pointY >= this.bottomLeft.getY() && pointY <= this.topRight.getY()) {
            return true;
        }
        return false;
    }
}
