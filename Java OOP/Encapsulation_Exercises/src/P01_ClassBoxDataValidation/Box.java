package P01_ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setHeight(height);
        this.setWidth(width);
        this.setLength(length);
    }

    private void setLength(double length) {
        if(!validSize(length)) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if(!validSize(width)) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if(!validSize(height)) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    private boolean validSize(double size) {
        if(size > 0) {
            return true;
        }
        return false;
    }

    public double calculateSurfaceArea() {
        return 2 * ((this.length * this.width) + (this.length * this.height) + (this.height * this.width));
    }

    public double calculateLateralSurfaceArea () {
        return 2 * ((this.length * this.height) + (this.height * this.width));
    }

    public double calculateVolume () {
        return this.length * this.width * this.height;
    }
}
