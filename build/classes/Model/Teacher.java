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
                +"<br>Περιγραφή καθήγητη : "+teacherDiscription
                +"</html>";
    }

    @Override
    public String toString() {
        return "Όνομα καθηγητή : "+teacherName;
    }

    public ArrayList<Subject> getAllSubjects() {
        return teacherSubjects;
    }
    
    
}
