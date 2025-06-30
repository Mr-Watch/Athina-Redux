package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Submission implements Serializable{
    private Student submissionStudent;
    private ArrayList<SubmissionEntry> submissionEntrys;

    public Submission(Student submissionStudent, ArrayList<SubmissionEntry> submissionEntrys) {
        this.submissionStudent = submissionStudent;
        this.submissionEntrys = submissionEntrys;
    }
    
    public ArrayList<SubmissionEntry> getSubmissionEntrys() {
        return submissionEntrys;
    }

    public Student getSubmissionStudent() {
        return submissionStudent;
    }
    
    @Override
    public String toString() {
        String returnString = "";
        
        for(SubmissionEntry submissionEntry : submissionEntrys){
            returnString += submissionEntry.toString() + "\n";
        }
        return returnString; 
                
    }
    
    
    
}
