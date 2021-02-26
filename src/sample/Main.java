package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Test Git");
        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.fillOval(60, 120, 30, 30);
        gc.strokeOval(60, 120, 30, 30);

        gc.fillOval(180, 120, 30, 30);
        gc.strokeOval(180, 120, 30, 30);

        gc.strokePolygon(new double[]{44, 224, 234, 180, 165, 120, 105, 54},
                new double[]{135, 135, 100, 100, 70,70,100, 100}, 8);

        gc.setStroke(Color.GREY);
        gc.strokeLine(0,153,300,153);


    }


    public static void main(String[] args) {
        launch(args);
    }
}
