package shapes;

public class TriangularPrism extends Prism {

    // Constructor for TriangularPrism
    public TriangularPrism(double height, double side) {
        super(height, side);
    }

    @Override
    public double calcBaseArea() {
        // A = (s²√3) / 4 (Area of the equilateral triangular base)
        return (Math.pow(this.getSide(), 2) * Math.sqrt(3)) / 4;
    }
}