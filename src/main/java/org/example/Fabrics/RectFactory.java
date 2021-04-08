package org.example.Fabrics;

import javafx.scene.paint.Paint;
import org.example.Figures.Rect;
import org.example.Figures.Shapes;

import java.util.List;

public class RectFactory implements ShapeFactory{
    @Override
    public Shapes createShape(List<Double> point, Paint outlineColor, Paint brushColor, double lineWeight) {
        return (new Rect(point, outlineColor, brushColor, lineWeight));
    }
}
