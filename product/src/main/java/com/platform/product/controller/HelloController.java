package com.platform.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/msg")
    public String msg(){
        return "this is  my msg";
    }
}
