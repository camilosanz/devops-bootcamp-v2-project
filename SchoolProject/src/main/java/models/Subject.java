package models;

import helpers.Grade;

public class Subject {
    private String name;
    private Teacher teacher;
    private Grade grade;

    public Subject(String name, Teacher teacher, Grade grade) {
        this.name = name;
        this.teacher = teacher;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }
}
