package org.example;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

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


    public void showMouseCoordinates(MouseEvent e) {
        mouseCoordinates.setText(model.showMouseCoordinates(e.getX(), e.getY()));
    }


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
        }
        catch(Exception err ){
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
        canvas.setOnMouseMoved(event -> {
            String koordinates = String.format("X: %.0f  Y: %.0f", event.getX(), event.getY());
            mouseCoordinates.setText(koordinates);
        });
    }

    public void clearCanvas(){
        model.fullClearCanvas();
    }

    public void Pen(){
        model.drawingDifficultShapes(0);
    }

    public void figLine() {
        model.drawingSimpleShapes(1);
    }

    public void figRect() {
        model.drawingSimpleShapes(2);
    }

    public void figCirc(){
        model.drawingSimpleShapes(3);
    }

    public void figEllips(){
        model.drawingSimpleShapes(4);
    }

    public void figPolygon(){
        model.drawingDifficultShapes(5);
    }


}
