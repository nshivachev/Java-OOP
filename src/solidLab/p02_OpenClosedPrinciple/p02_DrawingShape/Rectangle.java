package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Draw Rectangle");
    }
}
