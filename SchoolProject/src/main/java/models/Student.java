package models;

import java.util.ArrayList;
import java.util.List;

import helpers.Grade;
import helpers.Score;

public class Student implements User {
    private String code;
    private String name;
    private int age;
    private Grade grade;
    private Score score;
    private List<SubjectScore> subjectList = new ArrayList<>();

    public Student(String name, int age, Grade grade) {
        this.code = "ST" + (int)(Math.random() * 100 + 1) + name;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public String getScore() {
        return getScore();
    }

    public String getName() {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }

    public List<SubjectScore> getSubjectList() {
        return subjectList;
    }
}
