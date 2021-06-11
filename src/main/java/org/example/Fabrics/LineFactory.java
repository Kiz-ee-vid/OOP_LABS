package org.example.Fabrics;

import org.example.Figures.Line;
import org.example.core.SeriaColor;
import org.example.core.ShapeFactory;
import org.example.core.Shapes;

import java.util.List;

public class LineFactory implements ShapeFactory {
    @Override
    public Shapes createShape(List<Double> point, SeriaColor outlineColor, SeriaColor brushColor, double lineWeight) {
        return (new Line(point, outlineColor, lineWeight));
    }
}
