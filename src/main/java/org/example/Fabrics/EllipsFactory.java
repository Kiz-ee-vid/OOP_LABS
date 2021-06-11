package org.example.Fabrics;

import org.example.Figures.Ellips;
import org.example.core.SeriaColor;
import org.example.core.ShapeFactory;
import org.example.core.Shapes;

import java.util.List;

public class EllipsFactory implements ShapeFactory {
    @Override
    public Shapes createShape(List<Double> point, SeriaColor outlineColor, SeriaColor brushColor, double lineWeight) {
        return (new Ellips(point, outlineColor, brushColor, lineWeight));
    }
}
