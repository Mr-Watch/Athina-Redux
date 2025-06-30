package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Student extends User implements Serializable{

    private String studentName;
    private int studentSummester;
    private Submission studentCurrentSubmission;

    public Student(String userName, String userPassword, String studentName, int studentSummester) {
        super(userName, userPassword);
        this.studentName = studentName;
        this.studentSummester = studentSummester;
    }

    public Submission makeASubmission(ArrayList<Subject> subjects) {
        ArrayList<SubmissionEntry> submissionEntrys;
        submissionEntrys = new ArrayList<>();
        for (Subject subject : subjects) {
            submissionEntrys.add(new SubmissionEntry(subject, 0));
        }
        studentCurrentSubmission = new Submission(this, submissionEntrys);
        return studentCurrentSubmission;
    }

    public int getStudentSummester() {
        return studentSummester;
    }
    
    public Submission getStudentCurrentSubmission() {
        return studentCurrentSubmission;
    }
    
}
