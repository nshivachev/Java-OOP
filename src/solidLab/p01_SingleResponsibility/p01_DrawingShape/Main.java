package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingRepository;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderer;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 10);
        Renderer renderer = new RendererImpl();
        DrawingRepository drawingRepository = new DrawingRepositoryImpl();

        rectangle.draw(renderer, drawingRepository);
    }
}
