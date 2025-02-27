package shapes;

/**
 * Class representing a Pentagonal Prism.
 */
public class PentagonalPrism extends Prism {
    
    public PentagonalPrism(double height, double side) {
        super(height, side);
    }
    
    @Override
    public double calcBaseArea() {
        // Calculate tan(54°) in radians.
        return (5 * side * side * Math.tan(Math.toRadians(54))) / 4;
    }
    
    @Override
    public double calcVolume() {
        return calcBaseArea() * height;
    }
}
