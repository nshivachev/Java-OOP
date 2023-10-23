package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingRepository;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderer;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class RendererImpl implements Renderer {
    @Override
    public void render(DrawingRepository drawingRepository, Shape shape) {
        System.out.printf("Rendering shape %s on the %s", shape, drawingRepository);
    }
}
