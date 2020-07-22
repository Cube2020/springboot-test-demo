package com.lennon.springbootdemo.controller;

import com.lennon.springbootdemo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService service;

    @RequestMapping("/greeting")
    public String greeting() {
        return service.greet();
    }
}
