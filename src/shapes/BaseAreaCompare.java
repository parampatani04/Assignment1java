package shapes;

import java.util.Comparator;

public class BaseAreaCompare implements Comparator<Shape> {

    @Override
    public int compare(Shape shp1, Shape shp2) {
        // Using Double.compare to make the code cleaner
        return Double.compare(shp1.calcBaseArea(), shp2.calcBaseArea());
    }
}