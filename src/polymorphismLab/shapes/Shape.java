package polymorphismLab.shapes;

public abstract class Shape {

    private Double perimeter;
    private Double area;

    Double getPerimeter() {
        return perimeter;
    }

    Double getArea() {
        return area;
    }

    void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    void setArea(double area) {
        this.area = area;
    }

    abstract Double calculatePerimeter();

    abstract Double calculateArea();
}
