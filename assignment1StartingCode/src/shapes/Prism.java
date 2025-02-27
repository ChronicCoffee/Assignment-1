package shapes;

/**
 * Abstract class representing a prism.
 * Extends Shape and includes an edge length (side).
 */
public abstract class Prism extends Shape {
    protected double side;
    
    public Prism(double height, double side) {
        super(height);
        this.side = side;
    }
    
    public double getSide() {
        return side;
    }
}
