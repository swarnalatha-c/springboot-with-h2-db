package com.example.demo.service;

import com.example.demo.model.Sample;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Sample> getStudent() {
        List<Student> studentList = new ArrayList<>();
                studentRepository.findAll().forEach(studentList::add);
        //List<Sample> sampleList = (List<Sample>) Arrays.asList(studentList);
       return studentList.stream().map(this::toSample).collect(Collectors.toCollection(LinkedList::new));

    }

    private Sample toSample(Student student) {
       Sample sample= new Sample();
       sample.setId(student.getId());
       sample.setName(student.getName());
       return sample;
    }

    public void addStudent(Sample sample) {
        Student student= new Student();
        student.setId(sample.getId());
        student.setName(sample.getName());
        studentRepository.save(student);

    }
}
