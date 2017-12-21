package com.example.service;

import com.example.dao.StudentMapper;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public Integer addStudent(Student student){
        return studentMapper.addStudent(student);
    }

    public Student findStudent(Integer no){
        Student student = studentMapper.findStudentByNumber(no);
        return student;
    }

    public List<Student> getStudents() {
        List<Student> students = studentMapper.listStudents();
        return students;
    }

    public Integer updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    public Integer deleteStudent(Integer no) {
        return studentMapper.deleteStudent(no);
    }
}
