package com.ljj.spring.ioc;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/12/5 14:40
 */
public class Teacher1 {
    private String id;

    private String name;

    private Student www;


    public Student getWww() {
        return www;
    }

    public void setWww(Student www) {
        this.www = www;
    }

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

    @Override
    public String toString() {
        return "Teacher1{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", student=" + www +
                '}';
    }
}
