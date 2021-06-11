package org.example.Figures;

import javafx.scene.canvas.GraphicsContext;
import org.example.core.SeriaColor;
import org.example.core.Shapes;

import java.io.Serializable;
import java.util.List;

public class Line extends Shapes implements Serializable {
    public Line(List<Double> point, SeriaColor outlineColor, double lineWeight) {

        this.outline = outlineColor;
        this.lineWeight = lineWeight;
        this.point.addAll(point);
    }
    @Override
    public void draw(GraphicsContext g)  {
        g.setStroke(outline.getSerialColor());
        g.setLineWidth(lineWeight);
        g.strokeLine(point.get(0), point.get(1), point.get(2), point.get(3));
    }
}
