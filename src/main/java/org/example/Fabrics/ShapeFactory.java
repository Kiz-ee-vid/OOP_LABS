package org.example.Fabrics;

import javafx.scene.paint.Paint;
import org.example.Figures.Shapes;
import org.example.SeriaColor;

import java.util.List;

public interface ShapeFactory {
    Shapes createShape(List<Double> point, SeriaColor outlineColor, SeriaColor brushColor, double lineWeight) ;
}
