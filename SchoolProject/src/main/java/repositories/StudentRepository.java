package repositories;

import models.Student;
import models.SubjectScore;
import helpers.Grade;
// import helpers.Score;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements Repository<Student>{
    private List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    public List<Student> getAll() {
        return this.students;
    }

    public Student getByCode(String code) {
        return students.stream().filter(student -> student.getCode().equals(code)).findAny().orElse(null);
    }

    public List<Student> getByGrade(Grade grade){
        return students.stream().filter(student -> student.getGrade().equals(grade)).toList();
    }

    public void add(Student s) {
        this.students.add(s);
    }

    public void addElementSubject(SubjectScore sub, String code) {
        this.getByCode(code).getSubjectList().add(sub);
    }

    public void editScore(Student s) {
        int oldStudentIndex = students.indexOf(this.getByCode(s.getCode()));
        students.set(oldStudentIndex, s);
        
    }

    public List<SubjectScore> getSubjects(String code) {
        return this.getByCode(code).getSubjectList();
    }

    public SubjectScore getElementSubjectByName(String name, String code) {
        return this.getSubjects(code).stream().filter(sub -> sub.getName().equals(name)).findAny().orElse(null);
    }

}
