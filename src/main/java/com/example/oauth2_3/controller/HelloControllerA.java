package com.example.oauth2_3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerA {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
