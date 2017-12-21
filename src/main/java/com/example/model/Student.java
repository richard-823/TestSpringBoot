package com.example.model;

public class Student {
    private Integer no;
    private String name;
    private Integer age;

    public Integer getNo() {
        return no;
    }
    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Student()
    {

    }
    public Student(Integer no, String name, Integer age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

}