package com.example.april2024.repository;

import com.example.april2024.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> findByCity(String city);
    //select * from student where city=?

    public List<Student> findByName(String name);

    public List<Student> findByNameOrCity(String name, String city);
    //select * from student where name=? or city=?

}
