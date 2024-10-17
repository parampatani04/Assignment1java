package shapes;

public class SquarePrism extends Prism {
    public SquarePrism(double height, double side) {
        super(height, side);
    }

    @Override
    public double calcBaseArea() {
        // Base area of square = side^2
        return Math.pow(this.getSide(), 2);
    }
}