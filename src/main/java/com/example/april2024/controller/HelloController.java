package com.example.april2024.controller;

import com.example.april2024.model.Message;
import com.example.april2024.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/greet")
    public String sayHello(){
        return "WELCOME TO SPRINGBOOT FRAMEWORK";
    }

    // http://localhost:2024/april2024/hello/greet/VAMSHI
    @GetMapping("/greet/{input}")
    public String sayHello(@PathVariable("input") String inputString){
        return "HI "+inputString+", WELCOME TO SPRINGBOOT FRAMEWORK";
    }

    // http://localhost:2024/april2024/hello/greetwithparams?input=VAMSHI
    @GetMapping("/greetwithparams")
    public String sayHelloWithParams(@RequestParam("input") String inputString){
        return "HI "+inputString+", WELCOME TO SPRINGBOOT FRAMEWORK - WITH REQUEST PARAM";
    }

    @PostMapping("/post")
    public void postMessage(@RequestBody Message message){
        System.out.println("Message ID: "+message.getMsgid()+" and Message: "+message.getMsg());
    }

    @PostMapping("/post/student")
    public void postMessage(@RequestBody Student student){
        System.out.println("Roll No: "+student.getRollno()+" and Name: "+student.getName());
    }

}

//Inversion Of Control - creation of beans/objects by Spring Container
// @RestController
// @Controller
// @Service
// @Repository
// @Component
// @Bean