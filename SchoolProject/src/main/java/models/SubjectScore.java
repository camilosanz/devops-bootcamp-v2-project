package models;

import helpers.Score;

public class SubjectScore {
    private String subject;
    private Score score;

    public SubjectScore(Subject subject, Score score){
        this.subject = subject.getName();
        this.score = score;
    }

    public String getName(){
        return subject;
    }

    public Score getScore(){
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
