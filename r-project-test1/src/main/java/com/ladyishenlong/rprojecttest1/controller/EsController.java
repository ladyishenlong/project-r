package com.ladyishenlong.rprojecttest1.controller;

import com.ladyishenlong.rprojecttest1.model.Student;
import com.ladyishenlong.rprojecttest1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @Author ruanchenhao
 * @Date 2019-05-17 15:58
 *
 * es的使用
 */
@RequestMapping("/es")
@RestController
public class EsController {


    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/save")
    public void save(){
        Student student=new Student();
        student.setId("666");
        student.setName("天空");
        studentRepository.save(student);
    }

    @GetMapping("/findAll")
    public Iterable<Student> findById(){
        return studentRepository.findAll();
    }




}
