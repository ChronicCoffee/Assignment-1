package shapes;

/**
 * Abstract class representing a three-dimensional geometric shape.
 * Implements Comparable interface to compare shapes by height.
 */
public abstract class Shape implements Comparable<Shape> {
    protected double height;
    
    public Shape(double height) {
        this.height = height;
    }
    
    public double getHeight() {
        return height;
    }
    
    /**
     * Calculates the volume of the shape.
     * @return volume
     */
    public abstract double calcVolume();
    
    /**
     * Calculates the base area of the shape.
     * @return base area
     */
    public abstract double calcBaseArea();
    
    /**
     * Compares shapes based on height.
     */
    @Override
    public int compareTo(Shape s) {
        return Double.compare(this.height, s.height);
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " [height=" + height 
                + ", volume=" + String.format("%.2f", calcVolume()) 
                + ", baseArea=" + String.format("%.2f", calcBaseArea()) + "]";
    }
}
