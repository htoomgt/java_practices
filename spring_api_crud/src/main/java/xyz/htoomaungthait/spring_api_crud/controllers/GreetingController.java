package xyz.htoomaungthait.spring_api_crud.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/")
    public String index() {
        return "<h1>Welcome to Spring API CRUD</h1>";
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello, World!";
    }


}
