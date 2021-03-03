package com.example.demo.controller;

import com.example.demo.model.Sample;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("students")
    List<Sample> getStudent(){
        return studentService.getStudent();
    }

  /*  @PostMapping("student")
    void addStudent(@RequestBody Student student){
        System.out.println("in controller");
        studentService.addStudent(student);*/
      @PostMapping("student")
        void addStudent(@RequestBody Sample sample){
           studentService.addStudent(sample);
           // return "success";
    }
}
