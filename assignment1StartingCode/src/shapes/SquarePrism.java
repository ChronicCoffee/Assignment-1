package shapes;

/**
 * Class representing a Square Prism.
 */
public class SquarePrism extends Prism {
    
    public SquarePrism(double height, double side) {
        super(height, side);
    }
    
    @Override
    public double calcBaseArea() {
        return side * side;
    }
    
    @Override
    public double calcVolume() {
        return calcBaseArea() * height;
    }
}
