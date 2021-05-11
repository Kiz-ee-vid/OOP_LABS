package org.example.Fabrics;

import javafx.scene.paint.Paint;
import org.example.Figures.Circ;
import org.example.Figures.Line;
import org.example.Figures.Shapes;
import org.example.SeriaColor;

import java.util.List;

public class LineFactory implements ShapeFactory{
    @Override
    public Shapes createShape(List<Double> point, SeriaColor outlineColor, SeriaColor brushColor, double lineWeight) {
        return (new Line(point, outlineColor, lineWeight));
    }
}
