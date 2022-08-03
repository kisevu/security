package com.ameda.kevin.client.service;

import com.ameda.kevin.client.entity.Student;
import com.ameda.kevin.client.model.StudentModel;
import com.ameda.kevin.client.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Student registerStudent(StudentModel studentModel) {
        Student student=Student.builder()
                .firstName(studentModel.getFirstName())
                .lastName(studentModel.getLastName())
                .emailAddress(studentModel.getEmailAddress())
                .password(passwordEncoder.encode(studentModel.getPassword()))
                .role("USER")
                .build();
        studentRepository.save(student);
        return student;
    }

    @Override
    public List<Student> showStudents() {
        List<Student> students=studentRepository.findAll();
        return students;
    }
}
