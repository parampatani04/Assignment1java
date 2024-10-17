package shapes;

public class PentagonalPrism extends Prism {

    // Constructor to initialize height and side using the parent class Prism
    public PentagonalPrism(double height, double side) {
        super(height, side);
    }

    @Override
    public double calcBaseArea() {
        // A = 5s²tan(54°) / 4 (Area of the pentagonal base)
        return (5 * Math.pow(this.getSide(), 2) * Math.tan(Math.toRadians(54))) / 4;
    }
}