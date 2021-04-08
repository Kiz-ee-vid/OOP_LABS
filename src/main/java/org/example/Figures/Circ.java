package org.example.Figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

import java.util.List;

public class Circ extends Shapes {
    public Circ(List<Double> point, Paint outlineColor, Paint brushColor, double lineWeight){

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
        double  diameter = Math.sqrt(Math.pow(point.get(2) - point.get(0), 2) + Math.pow(point.get(3) - point.get(1), 2));
        double centerX = point.get(0) - diameter / 2;
        double centerY = point.get(1) - diameter / 2;
        g.strokeOval(centerX, centerY, diameter, diameter);
        g.fillOval(centerX, centerY, diameter, diameter);

    }
}