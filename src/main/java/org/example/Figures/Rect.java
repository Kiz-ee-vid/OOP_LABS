package org.example.Figures;

import javafx.scene.paint.Color;

public class Rect extends Shapes {
    public Rect(Color line_color, int lineWeight) {
        this.outline = line_color;
        this.lineWeight = lineWeight;
    }
    @Override
    public void draw(int[] points) {
    }
}