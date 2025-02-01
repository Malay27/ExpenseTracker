package com.Malay.ExpenseTracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greeting(){
        return "Welcome to heaven!!!";
    }

    @RequestMapping("/about")
    public String about(){
        return "This is last time, you don't know about us ;D";
    }
}
