package com.ameda.kevin.client.controller;

import com.ameda.kevin.client.entity.Student;
import com.ameda.kevin.client.model.StudentModel;
import com.ameda.kevin.client.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping("/register")
    public String registerStudent(@RequestBody StudentModel studentModel){
        Student student=studentService.registerStudent(studentModel);
        return "successfully registered a student";
    }

    @GetMapping("/show-students")
    public List<Student> showStudents(){
        List<Student> students=studentService.showStudents();
        return students;
    }
}
