package org.example.Figures;

import javafx.scene.canvas.GraphicsContext;
import org.example.SeriaColor;

import java.io.Serializable;
import java.util.List;

public class Polygonum extends Shapes implements Serializable {
    public Polygonum(List<Double> point, SeriaColor outlineColor, SeriaColor brushColor, double lineWeight) {

        this.outline = outlineColor;
        this.background = brushColor;
        this.lineWeight = lineWeight;
        this.point.addAll(point);
    }
    @Override
    public void draw(GraphicsContext g) {
        g.setFill(background.getSerialColor());
        g.setStroke(outline.getSerialColor());
        g.setLineWidth(lineWeight);
        double[] pointX = new double[point.size()/2];
        double[] pointY = new double[point.size()/2];

        for(int i=0;i<point.size();i++){
            if (i%2==0){
                pointX[i/2] = point.get(i);
            }
            else{
                pointY[i/2] = point.get(i);
            }
        }
        g.fillPolygon(pointX, pointY, point.size()/2);
        g.strokePolygon(pointX, pointY, point.size()/2);
    }
}
