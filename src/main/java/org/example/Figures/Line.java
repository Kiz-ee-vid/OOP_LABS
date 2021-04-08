package org.example.Figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import java.util.List;

public class Line extends Shapes {
    public Line(List<Double> point, Paint outlineColor,  double lineWeight) {

        this.outline = outlineColor;
        this.lineWeight = lineWeight;
        this.point.addAll(point);
    }
    @Override
    public void draw(GraphicsContext g)  {
        g.setStroke(outline);
        g.setLineWidth(lineWeight);
        g.strokeLine(point.get(0), point.get(1), point.get(2), point.get(3));
    }
}
