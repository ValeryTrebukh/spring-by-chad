package com.jhedeen.chad58.rest;

import com.jhedeen.chad58.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Tom", "Sawyer"));
        students.add(new Student("Gekelbery", "Finn"));
        students.add(new Student("Rebecca", "Tetcher"));


        return students;
    }
}
