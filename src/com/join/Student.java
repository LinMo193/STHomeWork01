package com.join;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private String birDate;
    private boolean gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirDate() {
        return birDate;
    }

    public void setBirDate(String birDate) {
        this.birDate = birDate;
    }

    public void setGender(String gender) {
        this.gender = gender.equals("男")?true:false;
    }

    public String getGender() {
        return gender?"男":"女";
    }

    public Student() {
    }

    public Student(int id, String name, String birDate, String gender) {
        this.id = id;
        this.name = name;
        this.birDate = birDate;
        this.gender = gender.equals("男")?true:false;
    }

    @Override
    public int compareTo(Student student) {
        return this.getId()-student.getId();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birDate='" + birDate + '\'' +
                ", gender=" + gender +
                '}';
    }
}
