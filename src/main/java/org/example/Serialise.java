package org.example;

import javafx.stage.FileChooser;
import java.io.File;

public class Serialise {


    public File Open() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("*.paint", "*.paint");
        fileChooser.getExtensionFilters().add(filter);
        File file = fileChooser.showOpenDialog(null);
        return file;
    }

    public File Save() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("figures");
        FileChooser.ExtensionFilter extension = new FileChooser.ExtensionFilter("*.paint", "*.paint");
        fileChooser.getExtensionFilters().add(extension);
        File file = fileChooser.showSaveDialog(null);
        return file;
    }
}
