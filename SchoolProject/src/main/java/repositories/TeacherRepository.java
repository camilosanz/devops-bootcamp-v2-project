package repositories;

import models.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements Repository<Teacher> {
    private List<Teacher> teachers;

    public TeacherRepository() {
        this.teachers = new ArrayList<>();
    }

    public List<Teacher> getAll() {
        return this.teachers;
    }

    public Teacher getByCode(String code) {
        return teachers.stream().filter(teacher -> teacher.getCode().equals(code)).findAny().orElse(null);
    }

    public void add(Teacher t) {
        this.teachers.add(t);
    }
}
