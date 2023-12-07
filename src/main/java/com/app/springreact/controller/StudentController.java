package com.app.springreact.controller;

import com.app.springreact.model.entity.Student;
import com.app.springreact.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);

        return "New studednt is added";
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

}
