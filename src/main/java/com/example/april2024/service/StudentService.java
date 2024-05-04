package com.example.april2024.service;

import com.example.april2024.model.Student;
import com.example.april2024.repository.StudentRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
        //select * from student;
    }

    public Student getStudentByRollno(int rollno){
        Optional<Student> opStudent =  studentRepository.findById(rollno);
        if(opStudent.isPresent())
            return opStudent.get();
        else
            return new Student();
        //select * from student where rollno=?
    }

    public void saveStudent(Student student){
        //check the record the db
        // if present, it will update the record
        // if not, then it will insert the record
        studentRepository.save(student);
        //insert into student....
        //saveAll
    }

    public void saveAllStudents(List<Student> students){
        studentRepository.saveAll(students);
    }

    public void deleteStudent(int rollno){
        studentRepository.deleteById(rollno);
    }
}
