package org.example.Figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import java.util.ArrayList;
import java.util.List;

public class Shapes {
    protected List<Double> point = new ArrayList<>();
    protected Paint outline;
    protected Paint background;
    protected double lineWeight;

    public void draw(GraphicsContext g) {
    }
}
