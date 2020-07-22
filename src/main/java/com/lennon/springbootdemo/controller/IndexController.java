package com.lennon.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    
    @Value("${alexAge}")
    private int age;

    @GetMapping("/")
    public String index() {
        return "Index" + age;
    }
}
