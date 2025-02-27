package shapes;

/**
 * Class representing a Triangular Prism with an equilateral triangle as base.
 */
public class TriangularPrism extends Prism {
    
    public TriangularPrism(double height, double side) {
        super(height, side);
    }
    
    @Override
    public double calcBaseArea() {
        return (Math.sqrt(3) / 4) * side * side;
    }
    
    @Override
    public double calcVolume() {
        return calcBaseArea() * height;
    }
}
