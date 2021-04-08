package org.example.Figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import java.util.List;

public class Polyline extends Shapes{
    public Polyline(List<Double> point, Paint outlineColor, Paint brushColor, double lineWeight) {

        this.outline = outlineColor;
        this.background = brushColor;
        this.lineWeight = lineWeight;
        this.point.addAll(point);
    }
    @Override
    public void draw(GraphicsContext g) {
        g.setFill(background);
        g.setStroke(outline);
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

        g.strokePolyline(pointX, pointY, point.size()/2);

    }
}
