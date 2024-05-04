package com.example.april2024.controller;

import com.example.april2024.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    @Autowired //Dependency Injection
    CalculatorService service;

    @GetMapping("/divide/{a}/{b}")
    public ResponseEntity<Object> divide(@PathVariable("a") double first,
                                 @PathVariable("b") double second){
       if(first == 0 || second == 0){
           return new ResponseEntity<>("One of the input is 0, please check and re-try", HttpStatus.BAD_REQUEST);
       }
       else
           return new ResponseEntity<>(service.divide(first, second), HttpStatus.OK);
    }
}
