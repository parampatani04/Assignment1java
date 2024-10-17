package shapes;

public class Cone extends Shape {

    private double radius;

    // Constructor that initializes height using the superclass constructor
    public Cone(double height, double radius) {
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
        // V = (Base Area * Height) / 3
        return (calcBaseArea() * getHeight()) / 3;
    }

    @Override
    public double calcBaseArea() {
        // A = πr²
        return Math.PI * Math.pow(radius, 2);
    }
}