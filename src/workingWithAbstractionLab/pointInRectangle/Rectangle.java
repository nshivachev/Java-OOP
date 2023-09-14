package workingWithAbstractionLab.pointInRectangle;

public class Rectangle {
    private Point a;
    private Point c;

    public Rectangle(Point a, Point c) {
        this.a = a;
        this.c = c;
    }

    public boolean contains(Point point) {
        return point.greaterOrEqual(a) && point.lessOrEqual(c);
    }
}
