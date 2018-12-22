package com.jhedeen.chad58.rest;

import com.jhedeen.chad58.entity.Student;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student("Tom", "Sawyer"));
        students.add(new Student("Gekelbery", "Finn"));
        students.add(new Student("Rebecca", "Tetcher"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) throws StudentNotFoundException {

        if(id < 0 || id > students.size()) {
            throw new StudentNotFoundException("Student is nod found for id " + id);
        }
        return students.get(id);
    }
}
