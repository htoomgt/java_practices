package xyz.htoomaungthait.emsbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "<h1> Welcome to the spring boot employee management system!</h1>";
    }
}
