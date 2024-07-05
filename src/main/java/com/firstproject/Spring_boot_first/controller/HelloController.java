package com.firstproject.Spring_boot_first.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
 @GetMapping("/")
    public String helloWorld(){
        return "Welcome to First Spring boot Projectvvvv";
    }
}
