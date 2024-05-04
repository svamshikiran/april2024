package com.example.april2024.controller;

import com.example.april2024.model.Student;
import com.example.april2024.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/get/{rollno}")
    @Operation(description = "This method will return the student record, based on the rollno provided. If the student record doesn't exist, it will throw 400 error")
    @ApiResponse(description = "STUDENT DOESN'T EXIST or ROLLNO IS 0 or -ve", responseCode = "400")
    public ResponseEntity<Object> getStudentByRollno(@PathVariable("rollno") int rollno){
        if(rollno <= 0 ){
            log.error("Rollno - {} provided is -ve or zero, hence returning 400 response", rollno);
            return new ResponseEntity<>("ROLLNO's CAN'T BE NEGATIVE", HttpStatus.BAD_REQUEST);
        }
        Student student = studentService.getStudentByRollno(rollno);
        if(student.getRollno()==0){
            log.error("Student doesn't exist for the given rollno - {}, hence returning 400 response", rollno);
            return new ResponseEntity<>("STUDENT DOESN'T EXISTS", HttpStatus.BAD_REQUEST);
        }
        else{
            log.info("Student exists for the provided rollno - {}", rollno);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @PostMapping("/addall")
    public void addAllStudents(@RequestBody List<Student> studentList)
    {
        studentService.saveAllStudents(studentList);
    }

    @PutMapping("/update/{rollno}")
    public void updateStudent(@PathVariable("rollno") int rollno,
                              @RequestBody Student student){
        studentService.saveStudent(student);
    }

    @DeleteMapping("/delete/{rollno}")
    public void deleteStudent(@PathVariable("rollno") int rollno){
        studentService.deleteStudent(rollno);
    }
}
