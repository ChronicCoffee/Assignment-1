package shapes;

/**
 * Class representing a Pyramid.
 */
public class Pyramid extends Shape {
    private double side;
    
    public Pyramid(double height, double side) {
        super(height);
        this.side = side;
    }
    
    public double getSide() {
        return side;
    }
    
    @Override
    public double calcBaseArea() {
        return side * side;
    }
    
    @Override
    public double calcVolume() {
        return (1.0/3.0) * calcBaseArea() * height;
    }
}
