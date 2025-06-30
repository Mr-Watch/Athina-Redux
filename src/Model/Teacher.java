package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Teacher extends User implements Serializable {
    private String teacherName;
    private String teacherDiscription;
    private ArrayList<Subject> teacherSubjects = new ArrayList<Subject>();

    public Teacher(String userName, String userPassword, String teacherName, String teacherDiscription) {
        super(userName, userPassword);
        this.teacherName = teacherName;
        this.teacherDiscription = teacherDiscription;
    }
    
    public Request makeRequestToChangeGrade(String sender, String targer, String subject, float grade){
        if (grade < 0 || grade > 10) {
            return new Request("", "", "", 0);
        }
        return new Request(sender, targer, subject, grade);
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getTeacherDiscription() {
        return teacherDiscription;
    }
    
    public void addSubject(Subject subject){
        teacherSubjects.add(subject);
    }
        
    public Subject getSubject(){
        return teacherSubjects.get(0);
    }
    
    public String toStringBasic(){
        return "<br>Όνομα καθηγητή : "+teacherName
                +"<br>Περιγραφή καθηγητή : "+teacherDiscription
                +"</html>";
    }

    @Override
    public String toString() {
        return "Όνομα : "+teacherName;
    }

    public ArrayList<Subject> getAllSubjects() {
        return teacherSubjects;
    }
    
    public String computeStudentStats(float[] studentsGrades) {
        int studentCount = studentsGrades.length;
        int studentsPassed = 0;
        int studentsFailed = 0;
        int sum = 0;
        for (int i = 0; i < studentCount; i++) {
            sum += studentsGrades[i];

            if (studentsGrades[i] >= 5) {
                studentsPassed++;
            } else {
                studentsFailed++;
            }
        }
        float averageGrade = (float) (sum) / studentCount;
        float passedPercent = (float) (studentsPassed * 100) / studentCount;
        float failedPercent = 100 - passedPercent;

        return "<html>Αριθμός φοιτητών : " + studentCount
                + "<br>Αριθμός επιτυχόντων : " + studentsPassed
                + "<br>Αριθμός αποτυχόντων : " + studentsFailed
                + "<br>Μέσως όρος : " + averageGrade
                + "<br>Ποσοστό επιτυχίας/αποτυχίας : " + passedPercent + " / " + failedPercent
                + "</html>";
    }
    
    
}
