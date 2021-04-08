package org.example.Figures;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

import java.util.List;

public class Ellips extends Shapes {
    public Ellips(List<Double> point, Paint outlineColor, Paint brushColor, double lineWeight) {

        this.outline = outlineColor;
        this.background = brushColor;
        this.lineWeight = lineWeight;
        this.point.addAll(point);
    }
    @Override
    public void draw(GraphicsContext g)  {
        g.setFill(background);
        g.setStroke(outline);
        g.setLineWidth(lineWeight);
        g.fillOval(Math.min(point.get(0), point.get(2)), Math.min(point.get(1), point.get(3)), Math.abs(point.get(0) - point.get(2)), Math.abs(point.get(1) - point.get(3)));
        g.strokeOval(Math.min(point.get(0), point.get(2)), Math.min(point.get(1), point.get(3)), Math.abs(point.get(0) - point.get(2)), Math.abs(point.get(1) - point.get(3)));
    }
}
