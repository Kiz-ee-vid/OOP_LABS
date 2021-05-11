package org.example.Fabrics;

import javafx.scene.paint.Paint;
import org.example.Figures.Rect;
import org.example.Figures.Shapes;
import org.example.SeriaColor;

import java.util.List;

public class RectFactory implements ShapeFactory{
    @Override
    public Shapes createShape(List<Double> point, SeriaColor outlineColor, SeriaColor brushColor, double lineWeight) {
        return (new Rect(point, outlineColor, brushColor, lineWeight));
    }
}
