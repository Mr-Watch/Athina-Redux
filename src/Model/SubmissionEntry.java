package Model;

import java.io.Serializable;

public class SubmissionEntry implements Serializable{
    private Subject subject;
    private float subjectGrade;

    public SubmissionEntry(Subject subject, float subjectGrade) {
        this.subject = subject;
        this.subjectGrade = subjectGrade;
    }

    public Subject getSubject() {
        return subject;
    }

    public float getSubjectGrade() {
        return subjectGrade;
    }

    public void setSubjectGrade(float subjectGrade) {
        this.subjectGrade = subjectGrade;
    }

    @Override
    public String toString() {
        return subject.getSubjectName() + " " + subjectGrade;
    }
    
}
