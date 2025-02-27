package shapes;

import java.util.Comparator;

/**
 * Comparator to compare shapes based on their volume.
 */
public class VolumeComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        return Double.compare(s1.calcVolume(), s2.calcVolume());
    }
}
