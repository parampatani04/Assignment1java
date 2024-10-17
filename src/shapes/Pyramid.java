package shapes;

public class Pyramid extends Shape {

    // Encapsulate the side length attribute
    private double side;

    // Constructor that initializes height and side
    public Pyramid(double height, double side) {
        super(height);  // Use the parent class constructor to set the height
        this.side = side;
    }

    // Getter for side
    public double getSide() {
        return side;
    }

    // Setter for side
    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double calcVolume() {
        // V = Ah / 3 (where A is base area and h is height)
        return (this.calcBaseArea() * this.getHeight()) / 3;
    }

    @Override
    public double calcBaseArea() {
        // A = s² (Area of the square base)
        return Math.pow(this.getSide(), 2);
    }
}