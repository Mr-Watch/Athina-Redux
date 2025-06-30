package Model;

import java.io.Serializable;

public class Request implements Serializable{
    String sender;
    String targer;
    String subject;
    float grade;

    public Request(String sender, String targer, String subject, float grade) {
        this.sender = sender;
        this.targer = targer;
        this.subject = subject;
        this.grade = grade;
    }

    public float getGrade() {
        return grade;
    }

    public String getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public String getTarger() {
        return targer;
    }

    public String[] toStringArray() {
        String [] returnString = {sender,targer,subject,String.valueOf(grade)};
        return returnString ;
    }
    
}
