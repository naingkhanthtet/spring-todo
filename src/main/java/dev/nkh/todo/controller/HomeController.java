package dev.nkh.todo.controller;

import dev.nkh.todo.config.ControllerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final ControllerProperties controllerProperties;

    public HomeController(ControllerProperties controllerProperties) {
        this.controllerProperties = controllerProperties;
    }

//    @GetMapping("/")
//    public ControllerProperties home() {
//        return controllerProperties;
//    }
}
