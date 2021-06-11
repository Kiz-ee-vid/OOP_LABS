package org.example.Figures;

import javafx.scene.canvas.GraphicsContext;
import org.example.core.SeriaColor;
import org.example.core.Shapes;

import java.io.Serializable;
import java.util.List;

public class Circ extends Shapes implements Serializable {
    public Circ(List<Double> point, SeriaColor outlineColor, SeriaColor brushColor, double lineWeight){

        this.outline = outlineColor;
        this.background = brushColor;
        this.lineWeight = lineWeight;
        this.point.addAll(point);
    }
    @Override
    public void draw(GraphicsContext g)  {
        g.setFill(background.getSerialColor());
        g.setStroke(outline.getSerialColor());
        g.setLineWidth(lineWeight);
        double  diameter = Math.sqrt(Math.pow(point.get(2) - point.get(0), 2) + Math.pow(point.get(3) - point.get(1), 2));
        double centerX = point.get(0) - diameter / 2;
        double centerY = point.get(1) - diameter / 2;
        g.strokeOval(centerX, centerY, diameter, diameter);
        g.fillOval(centerX, centerY, diameter, diameter);

    }
}