package org.example.Figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import org.example.SeriaColor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Shapes implements Serializable {
    protected List<Double> point = new ArrayList<>();
    protected SeriaColor outline;
    protected SeriaColor background;
    protected double lineWeight;

    public void draw(GraphicsContext g) {
    }
}
