package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Subject implements Serializable {

    private String subjectName;
    private String subjectDiscription;
    private int subjectCode;
    private int subjectEcts;
    private int subjectSemmester;
    private ArrayList<Teacher> subjectTeachers = new ArrayList<>();

    public Subject(String subjectName, String subjectDiscription, int subjectCode, int subjectEcts, int subjectSemmester) {
        this.subjectName = subjectName;
        this.subjectDiscription = subjectDiscription;
        this.subjectCode = subjectCode;
        this.subjectEcts = subjectEcts;
        this.subjectSemmester = subjectSemmester;
    }

    public int getSubjectSemmester() {
        return subjectSemmester;
    }
    
    public int getSubjectCode() {
        return subjectCode;
    }

    public void addTeachers(ArrayList<Teacher> teachers) {
        for (Teacher teacher : teachers) {
            subjectTeachers.add(teacher);
        }
    }

    public void addTeacher(Teacher teacher) {
        subjectTeachers.add(teacher);
    }

    public ArrayList<Teacher> getTeachers() {
        return subjectTeachers;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String toBasicString() {
        return "(" + subjectCode + ") - " + subjectName;
    }

    public String toStringFormated() {
        String returnString = "<html>Όνομα : " + subjectName
                + "<br>Κωδικός : " + subjectCode +""
                + "<br>Περιγραφή : " + subjectDiscription
                + "<br>Εξάμηνο : " + subjectSemmester
                + "<br>Πιστωτικές μονάδες ECTS : " + subjectEcts;

        for (Teacher teacher : subjectTeachers) {
            returnString += teacher.toStringBasic();
        }
        return returnString;
    }

    public String[] toTableString() {
        String []returnString = {subjectName,String.valueOf(subjectCode),String.valueOf(subjectEcts),String.valueOf(subjectSemmester)};
        return returnString;
    }


    
}
