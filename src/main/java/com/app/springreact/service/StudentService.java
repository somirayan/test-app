package com.app.springreact.service;

import com.app.springreact.model.entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getStudents();
}
