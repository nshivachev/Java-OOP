package polymorphismLab.shapes;

public class Rectangle extends Shape {

    private double height;
    private double width;

    Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
        super.setPerimeter(calculatePerimeter());
        super.setArea(calculateArea());
    }

    double getHeight() {
        return height;
    }

    double getWidth() {
        return width;
    }

    @Override
    Double calculatePerimeter() {
        return (height + width) * 2;
    }

    @Override
    Double calculateArea() {
        return height * width;
    }
}
