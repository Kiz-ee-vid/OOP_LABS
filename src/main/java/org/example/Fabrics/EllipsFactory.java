package org.example.Fabrics;

import javafx.scene.paint.Paint;
import org.example.Figures.Ellips;
import org.example.Figures.Shapes;
import org.example.SeriaColor;

import java.util.List;

public class EllipsFactory implements ShapeFactory{
    @Override
    public Shapes createShape(List<Double> point, SeriaColor outlineColor, SeriaColor brushColor, double lineWeight) {
        return (new Ellips(point, outlineColor, brushColor, lineWeight));
    }
}
