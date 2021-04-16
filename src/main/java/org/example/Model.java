package org.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.input.MouseButton;
import org.example.Figures.*;
import org.example.Fabrics.*;
import javafx.scene.paint.Paint;

public class Model {


    public final Canvas canvas;
    public final GraphicsContext g;
    private final List<Double> point = new ArrayList<>();
    private final List<Shapes> currentShape = new ArrayList<>();
    private final List<ShapeFactory> shapesFactoryList = Arrays.asList(new PolylineFactory(), new LineFactory(), new RectFactory(), new CircFactory(),new EllipsFactory(), new PolygonumFactory() );
    private Paint background;
    private Paint outline;
    private double lineWeight;

    public Model(Canvas canvas) {
        this.canvas = canvas;
        this.g = canvas.getGraphicsContext2D();
    }

    public void setFillColor(Paint color) {
        g.setFill(color);
        background = color;
    }

    public void setBorderColor(Paint color) {
        g.setStroke(color);
        outline = color;
    }

    public void setBorderSize(double size) {
        g.setLineWidth(size);
        lineWeight = size;
    }

    public void fullClearCanvas(){
        g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        UndoRedo.shapes.clear();
    }

    public void clearMouseEvents() {
        canvas.setOnMousePressed(event -> {});
        canvas.setOnMouseReleased(event -> {});
        canvas.setOnMouseDragged(event -> {});
        canvas.setOnMouseMoved(event -> {});
    }

    public void clearCanvas(GraphicsContext g) {
        this.g.clearRect(0,0,canvas.getWidth(), canvas.getHeight());
    }


    public void drawingSimpleShapes(int factoryNum){
        currentShape.clear();
        point.clear();
        clearMouseEvents();
        canvas.setOnMousePressed(event -> {
            point.add(0,event.getX());
            point.add(1,event.getY());
        });
        canvas.setOnMouseDragged(event -> {
            point.add(2,event.getX());
            point.add(3,event.getY());
            clearCanvas(g);
            for (Shapes shape : UndoRedo.shapes) {
                shape.draw(g);
            }
            currentShape.clear();
            ShapeFactory Factory = shapesFactoryList.get(factoryNum);
            currentShape.add(Factory.createShape(point, outline, background, lineWeight));
            currentShape.get(0).draw(g);
        });
        canvas.setOnMouseReleased(event -> {
            UndoRedo.shapes.add(currentShape.get(0));
            UndoRedo.History.clear();
        });
    }

    public void drawingDifficultShapes(int factoryNum){
        clearMouseEvents();
        point.clear();
        canvas.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                point.add(event.getX());
                point.add(event.getY());
                point.add(event.getX());
                point.add(event.getY());
            } else if (event.getButton() == MouseButton.SECONDARY) {
                point.set(point.size() - 1, event.getY());
                point.set(point.size() - 2, event.getX());
                UndoRedo.shapes.add(currentShape.get(0));
                UndoRedo.History.clear();
                point.clear();
            }
        });
        canvas.setOnMouseMoved(event -> {
            if(point.size() > 0) {
                clearCanvas(g);
                for(Shapes shape : UndoRedo.shapes) {
                    shape.draw(g);
                }
                point.set(point.size()-1,event.getY());
                point.set(point.size()-2,event.getX());
                currentShape.clear();
                ShapeFactory Factory = shapesFactoryList.get(factoryNum);
                currentShape.add(Factory.createShape(point, outline, background, lineWeight));
                currentShape.get(0).draw(g);
            }
        });
    }

}
