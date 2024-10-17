package shapes;

public class OctagonalPrism extends Prism {
    public OctagonalPrism(double height, double side) {
        super(height, side);
    }

    @Override
    public double calcBaseArea() {
        // Formula for base area of an octagonal prism
        return 2 * (1 + Math.sqrt(2)) * Math.pow(this.getSide(), 2);
    }
}