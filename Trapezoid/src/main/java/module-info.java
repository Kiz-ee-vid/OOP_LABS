import org.example.core.IService;
import org.example.plugins.trapezoid.Service;

module Trapezoid {
  requires core;

  requires javafx.controls;

  exports org.example.plugins.trapezoid;
  provides IService with Service;
}

