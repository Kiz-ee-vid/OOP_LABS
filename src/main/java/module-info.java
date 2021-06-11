module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires core;
    requires Trapezoid;

    opens org.example to javafx.fxml;
    exports org.example;
}