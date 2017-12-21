package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping(method=POST, value="/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
//        {
//            "no": 3,
//            "name": "ben",
//            "age": 25
//        }
        Integer result = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);

    }

    @RequestMapping(method=POST, value="/student/another")
    @ResponseStatus(HttpStatus.CREATED) // TODO: what if mulitpe return status?
    public Student addStudent2(@RequestBody Student student) {
        Integer result = studentService.addStudent(student);
        return student;
    }

    @RequestMapping(method=GET, value="/students")
    public ResponseEntity<List<Student>> listStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());
    }
    @RequestMapping(method=GET, value="/student/{no}")
    public ResponseEntity<Student> findStudent(@PathVariable Integer no) {
        Student student = studentService.findStudent(no);
        if (student != null) {
            return ResponseEntity.status(HttpStatus.OK).body(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(method=PUT, value="/student/{no}")
    public ResponseEntity<Student>  updateStudent(@PathVariable Integer no, @RequestBody Student student) {
        if (no.equals(student.getNo())) {
            Integer result = studentService.updateStudent(student);
            if (result == 1) {
                return ResponseEntity.status(HttpStatus.OK).body(student);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(method=DELETE, value="/student/{no}")
    public ResponseEntity<Integer>  deleteStudent(@PathVariable Integer no) {
        Integer result = studentService.deleteStudent(no);
        if (result == 1) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
