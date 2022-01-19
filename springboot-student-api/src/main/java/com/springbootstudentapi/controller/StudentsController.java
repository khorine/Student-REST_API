package com.springbootstudentapi.controller;

import com.springbootstudentapi.model.Student;
import com.springbootstudentapi.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
    private StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }
    //build get all students REST API
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    //build get student by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long studentId){
        return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);
    }
    //build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id,
                                                 @RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(id, student), HttpStatus.OK);
    }

    //build delete student REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){

        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student deleted successfully", HttpStatus.OK);
    }
}
