package org.example.Fabrics;

import javafx.scene.paint.Paint;
import org.example.Figures.Circ;
import org.example.Figures.Line;
import org.example.Figures.Shapes;
import java.util.List;

public class LineFactory implements ShapeFactory{
    @Override
    public Shapes createShape(List<Double> point, Paint outlineColor, Paint brushColor, double lineWeight) {
        return (new Line(point, outlineColor, lineWeight));
    }
}
