package org.example.Fabrics;

import org.example.Figures.Polygonum;
import org.example.core.SeriaColor;
import org.example.core.ShapeFactory;
import org.example.core.Shapes;

import java.util.List;

public class PolygonumFactory implements ShapeFactory {
    @Override
    public Shapes createShape(List<Double> point, SeriaColor outlineColor, SeriaColor brushColor, double lineWeight) {
        return (new Polygonum(point, outlineColor, brushColor, lineWeight));
    }
}
