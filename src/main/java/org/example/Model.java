package org.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import org.example.Figures.*;
import org.example.Fabrics.*;
import java.lang.module.Configuration;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.util.stream.Collectors;
import org.example.core.*;
import javafx.scene.paint.Color;

public class Model {


    public final Canvas canvas;
    public final GraphicsContext g;
    private final List<Double> point = new ArrayList<>();
    private final List<Shapes> currentShape = new ArrayList<>();
   // private final List<ShapeFactory> shapesFactoryList = Arrays.asList(new PolylineFactory(), new LineFactory(), new RectFactory(), new CircFactory(),new EllipsFactory(), new PolygonumFactory() );
    private SeriaColor background;
    private SeriaColor outline;
    private double lineWeight;
    private Serialise serialise;
    public Model(Canvas canvas) {
        this.canvas = canvas;
        this.g = canvas.getGraphicsContext2D();
        serialise = new Serialise();
    }

    public void loadPlugins(VBox plug) {
        Path pluginsDir = Paths.get("");

        ModuleFinder pluginsFinder = ModuleFinder.of(pluginsDir);

        List<String> plugins = pluginsFinder
                .findAll()
                .stream()
                .map(ModuleReference::descriptor)
                .map(ModuleDescriptor::name)
                .collect(Collectors.toList());

        Configuration pluginsConfiguration = ModuleLayer
                .boot()
                .configuration()
                .resolve(pluginsFinder, ModuleFinder.of(), plugins);

        ModuleLayer layer = ModuleLayer
                .boot()
                .defineModulesWithOneLoader(pluginsConfiguration, ClassLoader.getSystemClassLoader());

         List<IService>  services = IService.getServices(layer);

        for (IService service : services) {
            Button button = new Button();
            button.setOnAction(e -> {
                ShapeFactory shapeFactory = service.createFactory();
                drawingSimpleShapes(shapeFactory);
            });
            button.setText(service.getShapeName());
            button.setPrefWidth(160);
            button.setPrefHeight(30);

            plug.getChildren().add(button);
        }
    }

    public void setFillColor(Color color) {
        g.setFill(color);
        background = new SeriaColor(color);
    }

    public void setBorderColor(Color color) {
        g.setStroke(color);
        outline =  new SeriaColor(color);
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


    public void drawingSimpleShapes(ShapeFactory factory){
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
         // ShapeFactory Factory = shapesFactoryList.get(factoryNum);
            currentShape.add(factory.createShape(point, outline, background, lineWeight));
            currentShape.get(0).draw(g);
        });
        canvas.setOnMouseReleased(event -> {
            UndoRedo.shapes.add(currentShape.get(0));
            UndoRedo.History.clear();
        });
    }

    public void drawingDifficultShapes(ShapeFactory factory){
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
              //  ShapeFactory Factory = factory;
                currentShape.add(factory.createShape(point, outline, background, lineWeight));
                currentShape.get(0).draw(g);
            }
        });
    }

    public void Serialise() {
        File file = serialise.Save();
        try (ObjectOutputStream makefile = new ObjectOutputStream(new FileOutputStream(file)))
        {
            makefile.writeInt(UndoRedo.shapes.size());
            for (Shapes shape : UndoRedo.shapes) {
                makefile.writeObject(shape);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Deserialise() {
        File file = serialise.Open();
        clearCanvas(g);
        UndoRedo.shapes.clear();
        UndoRedo.History.clear();
        try(ObjectInputStream makefile = new ObjectInputStream(new FileInputStream(file)))
        {
            int length = makefile.readInt();
            for(int i = 0; i < length; i++) {
                UndoRedo.shapes.add((Shapes) makefile.readObject());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Shapes shape : UndoRedo.shapes) {
            shape.draw(g);
        }
    }
    }


