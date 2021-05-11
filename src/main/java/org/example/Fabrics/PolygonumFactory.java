package org.example.Fabrics;

import javafx.scene.paint.Paint;
import org.example.Figures.Polygonum;
import org.example.Figures.Shapes;
import org.example.SeriaColor;

import java.util.List;

public class PolygonumFactory implements ShapeFactory{
    @Override
    public Shapes createShape(List<Double> point, SeriaColor outlineColor, SeriaColor brushColor, double lineWeight) {
        return (new Polygonum(point, outlineColor, brushColor, lineWeight));
    }
}
