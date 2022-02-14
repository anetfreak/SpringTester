package com.beyondfoo.greeting.adapter.port.in;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String helloWorld() {
        return "Hello World from Spring Boot";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/bye")
    public String bye() {
        return "Goodbye!";
    }
}
