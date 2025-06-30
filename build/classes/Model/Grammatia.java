package Model;

import java.util.ArrayList;

public class Grammatia extends User {

    public Grammatia(String userName, String userPassword) {
        super(userName, userPassword);
    }

    public Grammatia() {
        super(null, null);
    }
    

    public Subject addNewSubject(String subjectName, String subjectDiscription, int subjectCode, int subjectEcts, int subjectSemmester, ArrayList<Teacher> teachers) {
        Subject toBeAddedSubject = new Subject(subjectName, subjectDiscription, subjectCode, subjectEcts, subjectSemmester);
        toBeAddedSubject.addTeachers(teachers);
        return toBeAddedSubject;
    }

    public SubmissionEntry validateTeacherRequest(SubmissionEntry entry, float studentGrade) {
        entry.setSubjectGrade(studentGrade);
        return entry;
    }
}
