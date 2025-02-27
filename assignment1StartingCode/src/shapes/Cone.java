package shapes;

/**
 * Class representing a Cone.
 */
public class Cone extends Shape {
    private double radius;
    
    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    @Override
    public double calcBaseArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calcVolume() {
        return (1.0/3.0) * calcBaseArea() * height;
    }
}
