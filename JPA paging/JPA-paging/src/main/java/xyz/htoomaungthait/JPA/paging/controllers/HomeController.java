package xyz.htoomaungthait.JPA.paging.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "this is JPA pagination app landing page!";
    }
}
