package org.example.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;

public class Shapes implements Serializable {
    protected List<Double> point = new ArrayList<>();
    protected SeriaColor outline;
    protected SeriaColor background;
    protected double lineWeight;

    public void draw(GraphicsContext g) {
    }
}
