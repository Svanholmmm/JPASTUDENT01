package org.example.jpastudent01.controller;

import org.example.jpastudent01.model.Student;
import org.example.jpastudent01.repositories.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StudentRestController {
    private final StudentRepository studentRepository;

    public StudentRestController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public List<Student> students(){
        var obj = studentRepository.findAll();
        return obj;
    }
    @GetMapping("/addStudent")
    public List<Student> addStudent(){
        Student std = new Student();
        std.setBornDate(LocalDate.now());
      var obj = studentRepository.findAll();
      return obj;
    }
    @GetMapping("students/{name}")
public List<Student> getAllStudentsByName(@PathVariable String name){
        return studentRepository.findAllByName(name);
    }

}
