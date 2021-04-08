package org.example.Fabrics;

import javafx.scene.paint.Paint;
import org.example.Figures.Shapes;
import java.util.List;

public interface ShapeFactory {
    Shapes createShape(List<Double> point, Paint outlineColor, Paint brushColor, double lineWeight) ;
}
