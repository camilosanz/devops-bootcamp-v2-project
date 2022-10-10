package models;

// import helpers.Grade;

import java.util.ArrayList;
import java.util.List;

public class Teacher implements User {
    private String code;
    private String name;
    private List<Subject> subjectList;

    public Teacher(String name) {
        this.code = "TE" + (int)(Math.random() * 100 + 1) + name;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void addSubject(Subject sub) {
        if (this.subjectList == null) {
            this.subjectList = new ArrayList<>();
        }

        this.subjectList.add(sub);
    }
}
