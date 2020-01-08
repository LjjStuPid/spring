package com.ljj.spring.ioc;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/12/5 14:39
 */
public class Teacher {

    private String id;

    private String name;

    private Student student;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
