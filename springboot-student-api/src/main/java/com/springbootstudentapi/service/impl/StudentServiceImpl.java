package com.springbootstudentapi.service.impl;

import com.springbootstudentapi.exception.ResourceNotFoundException;
import com.springbootstudentapi.model.Student;
import com.springbootstudentapi.repository.StudentRepository;
import com.springbootstudentapi.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException("Student","Id","id"));

    }

    @Override
    public Student updateStudent(Long id, Student student) {
        //check whether student exist on DB or not
        Student existingStudent = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student","Id","id"));

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setCourse(student.getCourse());

        //save existing student to DB
        studentRepository.save(existingStudent);
        return existingStudent;
    }

    @Override
    public void deleteStudent(long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student","Id","id"));
        studentRepository.deleteById(id);
    }
}
