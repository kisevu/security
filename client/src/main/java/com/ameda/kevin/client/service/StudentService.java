package com.ameda.kevin.client.service;

import com.ameda.kevin.client.entity.Student;
import com.ameda.kevin.client.model.StudentModel;

import java.util.List;

public interface StudentService {
    Student registerStudent(StudentModel studentModel);

    List<Student> showStudents();
}
