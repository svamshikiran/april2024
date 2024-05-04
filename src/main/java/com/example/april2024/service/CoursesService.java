package com.example.april2024.service;

import com.example.april2024.model.Courses;
import com.example.april2024.repository.CourseRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CoursesService {

    @Autowired
    CourseRespository cRepo;

    public List<Courses> getAllCourses(){
        return cRepo.findAll();
    }

}
