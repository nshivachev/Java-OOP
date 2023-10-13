package polymorphismLab.shapes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Shape rectangle = new Rectangle(5, 10);
        Shape circle = new Circle(9);

        List<Shape> shapes = new ArrayList<>(Arrays.asList(rectangle, circle));

        shapes.forEach(shape -> System.out.printf("Perimeter: %.2f, Area: %.2f%n", shape.getPerimeter(), shape.getArea()));
    }
}
