package shapes;

/**
 * Class representing a Cylinder.
 */
public class Cylinder extends Shape {
    private double radius;
    
    public Cylinder(double height, double radius) {
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
        return calcBaseArea() * height;
    }
}
