package com.example.dao;

import com.example.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentMapper {
    List<Student> listStudents();
    Integer addStudent(Student student);
    Integer updateStudent(Student student);
    Integer deleteStudent(Integer no);
    Student findStudentByNumber(Integer no);
}