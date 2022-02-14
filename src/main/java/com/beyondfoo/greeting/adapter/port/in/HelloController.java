package com.beyondfoo.greeting.adapter.port.in;

import com.beyondfoo.greeting.adapter.port.out.HelloResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public @ResponseBody
    HelloResponse helloWorld() {
        HelloResponse response = new HelloResponse();
        response.setMessage("Hello World from Spring Boot");
        return response;
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
