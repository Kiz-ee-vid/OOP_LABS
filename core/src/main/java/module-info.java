import org.example.core.IService;

module core {

  requires javafx.controls;

  exports org.example.core;

  uses IService;
}