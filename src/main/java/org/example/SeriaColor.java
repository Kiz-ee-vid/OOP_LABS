package org.example;

import javafx.scene.paint.Color;

import java.io.Serializable;

public class SeriaColor implements Serializable {

    private final double red;
    private final double green;
    private final double blue;
    private final double opacity;

    public SeriaColor(Color color) {
        this.red = color.getRed();
        this.green = color.getGreen();
        this.blue = color.getBlue();
        this.opacity = color.getOpacity();
    }
    public Color getSerialColor() {
        return new Color(red, green, blue, opacity);
    }
}
