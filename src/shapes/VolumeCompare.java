package shapes;

import java.awt.Shape;
import java.util.Comparator;

public class VolumeCompare implements Comparator<Shape> {
    @Override
    public int compare(Shape shp1, Shape shp2) {
        // Compare volumes of two shapes
        return Double.compare(shp1.calcVolume(), shp2.calcVolume());
    }
}