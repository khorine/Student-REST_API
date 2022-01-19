package com.springbootstudentapi.service;

import com.springbootstudentapi.model.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(long id);
    Student updateStudent(Long id,Student student);
    void deleteStudent(long id);
}
