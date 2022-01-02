package com.example.cicdstarterspring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class hello {
    @GetMapping("hello/{name}")
    public String hello(@PathVariable("name") String name){
        return "Hello Mr " + name;
    }
}
