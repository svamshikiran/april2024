package com.example.april2024.controller;

import com.example.april2024.model.Courses;
import com.example.april2024.service.CoursesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    private static final Logger log = LoggerFactory.getLogger(CoursesController.class);

    @Autowired
    CoursesService cService;

    @GetMapping("/all")
    public List<Courses> getAllCourses(){
        log.info("Control is here inside the CoursesController - getAllCourses()");
        return cService.getAllCourses();
    }

}
