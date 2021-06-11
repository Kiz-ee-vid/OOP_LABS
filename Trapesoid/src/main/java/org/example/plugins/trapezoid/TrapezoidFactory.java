package org.example.plugins.trapezoid;

import javafx.scene.shape.Shape;
import org.example.core.SeriaColor;
import org.example.core.ShapeFactory;
import org.example.core.Shapes;

import java.util.List;

public class TrapezoidFactory implements ShapeFactory {
  @Override
  public Shapes createShape(List<Double> point, SeriaColor outlineColor, SeriaColor brushColor, double lineWeight) {
    return (new Trapezoid(point, outlineColor, brushColor, lineWeight));
  }
}
