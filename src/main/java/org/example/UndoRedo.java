package org.example;

import org.example.core.Shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UndoRedo {

    public static List<Shapes> shapes = new ArrayList<>();
    public static Stack<Shapes> History = new Stack<>();

    public static void Undo(Model model){
        if (shapes.size()>0) {
            History.push(shapes.get(shapes.size() - 1));
            shapes.remove(shapes.size() - 1);
            model.clearCanvas(model.g);
            for (Shapes shape : shapes) {
                shape.draw(model.g);
            }
        }
    }

    public static void Redo(Model model){
        if (History.size()>0){
            shapes.add(History.pop());
            model.clearCanvas(model.g);
            for (Shapes shape : shapes) {
                shape.draw(model.g);
            }
        }
    }

}
