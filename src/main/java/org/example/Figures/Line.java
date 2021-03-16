package org.example.Figures;

import javafx.scene.paint.Color;

public class Line extends Shapes {
    public Line(Color line_color, int lineWeight) {
        this.outline = line_color;
        this.lineWeight = lineWeight;
    }
    @Override
    public void draw(int[] points) {
    }
}
