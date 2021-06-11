package org.example.plugins.trapezoid;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import org.example.core.SeriaColor;
import org.example.core.Shapes;

public class Trapezoid extends Shapes {
  public Trapezoid(List<Double> point, SeriaColor outlineColor, SeriaColor brushColor, double lineWeight) {

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

      double x = point.get(0);
      double y = point.get(1);
      double width = (point.get(2)-point.get(0));
      double height = (point.get(3) - point.get(1));

      double[] xPoints = {x, x + width * 0.25, x + width * 0.75, x + width};
      double[] yPoints = {y, y + height, y + height, y};


      g.fillPolygon(xPoints, yPoints, 4);
      g.strokePolygon(xPoints, yPoints, 4);

  }
}
