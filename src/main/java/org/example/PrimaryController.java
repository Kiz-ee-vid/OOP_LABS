package org.example;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import org.example.Fabrics.ShapeFactory;
import org.example.Figures.*;
import org.example.Fabrics.*;

import java.io.*;

public class PrimaryController {

    private Model model;

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker cpFill;

    @FXML
    private ColorPicker cpBorder;

    @FXML
    private TextField brushSize;

    @FXML
    private Label mouseCoordinates;

    ///переделать для возможности выбора отсутствия заливки, границы
    public void setFillColor() {
        model.setFillColor(cpFill.getValue());
    }

    public void setBorderColor() {
        model.setBorderColor(cpBorder.getValue());
    }

    public void setBorderSize() {
        try {
            model.setBorderSize(Double.parseDouble(brushSize.getText()));
        } catch (Exception err) {
            model.setBorderSize(1);
            brushSize.setText("1");
        }
    }


    public void initialize() {
        model = new Model(canvas);
        model.setFillColor(cpFill.getValue());
        model.setBorderColor(cpBorder.getValue());
        model.setBorderSize(1);
        brushSize.setText("1");
    }

    public void pressUndo() {
        UndoRedo.Undo(model);
    }

    public void pressRedo() {
        UndoRedo.Redo(model);
    }

    public void clearCanvas() {
        model.fullClearCanvas();
    }

    public void Pen() {
        model.drawingDifficultShapes(new PolylineFactory());
    }

    public void figLine() {
        model.drawingSimpleShapes(new LineFactory());
    }

    public void figRect() {
        model.drawingSimpleShapes(new RectFactory());
    }

    public void figCirc() {
        model.drawingSimpleShapes(new CircFactory());
    }

    public void figEllips() {
        model.drawingSimpleShapes(new EllipsFactory());
    }

    public void figPolygon() {
        model.drawingDifficultShapes(new PolygonumFactory());
    }

    public void Open() {
        model.Deserialise();
    }

    public void Save() {
        model.Serialise();
    }
}
