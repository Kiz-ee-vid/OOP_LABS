package org.example.core;

import java.util.List;

public interface ShapeFactory {
    Shapes createShape(List<Double> point, SeriaColor outlineColor, SeriaColor brushColor, double lineWeight) ;
}

