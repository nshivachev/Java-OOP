package polymorphismLab.shapes;

public class Circle extends Shape {

    private double radius;

    Circle(double radius) {
        this.radius = radius;
        setPerimeter(calculatePerimeter());
        setArea(calculateArea());
    }

    final double getRadius() {
        return radius;
    }

    @Override
    Double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    Double calculateArea() {
        return Math.PI * radius * radius;
    }
}
