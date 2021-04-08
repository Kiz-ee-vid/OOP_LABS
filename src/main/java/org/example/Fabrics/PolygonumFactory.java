package org.example.Fabrics;

import javafx.scene.paint.Paint;
import org.example.Figures.Polygonum;
import org.example.Figures.Shapes;

import java.util.List;

public class PolygonumFactory implements ShapeFactory{
    @Override
    public Shapes createShape(List<Double> point, Paint outlineColor, Paint brushColor, double lineWeight) {
        return (new Polygonum(point, outlineColor, brushColor, lineWeight));
    }
}
