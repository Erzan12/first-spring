package com.erzan.first_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "Spring boot is working";
    }

    @GetMapping("/me")
    public String me() {
        return "I am Iron Man";
    }
}
