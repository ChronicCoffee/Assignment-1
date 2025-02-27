package shapes;

/**
 * Class representing an Octagonal Prism.
 */
public class OctagonalPrism extends Prism {
    
    public OctagonalPrism(double height, double side) {
        super(height, side);
    }
    
    @Override
    public double calcBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * side * side;
    }
    
    @Override
    public double calcVolume() {
        return calcBaseArea() * height;
    }
}
