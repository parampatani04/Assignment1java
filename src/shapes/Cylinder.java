package shapes;

public class Cylinder extends Shape {

    private double radius;

    // Constructor that initializes height using the superclass constructor
    public Cylinder(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calcVolume() {
        // V = Ah (where A is base area and h is height)
        return calcBaseArea() * getHeight();
    }

    @Override
    public double calcBaseArea() {
        // A = πr²
        return Math.PI * Math.pow(radius, 2);
    }
}