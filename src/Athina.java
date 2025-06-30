
import Controler.ObjectReader;
import Controler.ObjectWriter;
import Model.Grammatia;
import Model.Student;
import Model.Subject;
import Model.Submission;
import Model.SubmissionEntry;
import Model.Teacher;
import java.util.ArrayList;

public class Athina {

    public static void main(String[] args) throws ClassNotFoundException {
        Subject sub1 = new Subject("Μαθηματικά Ι", "Υποχρεωτικό (ΥΠ)", 1101, 6, 1);
        Subject sub2 = new Subject("Δομές Δεδομένων", "Υποχρεωτικό (ΥΠ)", 1305, 6, 3);
        Subject sub3 = new Subject("Μικροελεγκτές", "Υποχρεωτικό (ΥΠ)", 1502, 6, 5);
        Subject sub4 = new Subject("Αριθμητικές Μέθοδοι", "Επιλογής (ΕΠ)", 1641, 6, 6);
        Subject sub5 = new Subject("Διοίκηση Έργων", "Επιλογής (ΕΠ)", 1643, 6, 6);
        Subject sub6 = new Subject("Γραφικά Υπολογιστών", "Επιλογής (ΕΠ)", 1969, 6, 9);
        
        Teacher teacher1 = new Teacher("panagiotis","761943","Παναγιώτης Π.","Αναπληρωτής");
        Teacher teacher2 = new Teacher("vasilis", "357159", "Βασίλειος Κ.", "Διδάσκων");
        
        teacher1.addSubject(sub1);
        teacher1.addSubject(sub2);
        teacher1.addSubject(sub3);
        teacher1.addSubject(sub6);
        
        teacher2.addSubject(sub4);
        teacher2.addSubject(sub5);
        teacher2.addSubject(sub3);
        teacher2.addSubject(sub6);
        
        sub1.addTeacher(teacher1);
        sub2.addTeacher(teacher1);
        sub3.addTeacher(teacher1);
        sub3.addTeacher(teacher2);
        sub4.addTeacher(teacher2);
        sub5.addTeacher(teacher2);
        sub6.addTeacher(teacher1);
        sub6.addTeacher(teacher2);
        
        ArrayList<Subject> subjects = new ArrayList<>();
        subjects.add(sub1);
        subjects.add(sub2);
        subjects.add(sub3);
        subjects.add(sub4);
        subjects.add(sub5);
        subjects.add(sub6);
        
        Student student1 = new Student("it223584", "204571", "Ιωάννης Π.", 2);
        Student student2 = new Student("it229470", "161457", "Νικόλαος Κ.", 2);
        
        ArrayList<SubmissionEntry> submissionEntrys1 = new ArrayList<>();
        ArrayList<SubmissionEntry> submissionEntrys2 = new ArrayList<>();
        
        submissionEntrys1.add(new SubmissionEntry(sub1, 1));
        submissionEntrys1.add(new SubmissionEntry(sub2, 8));
        submissionEntrys1.add(new SubmissionEntry(sub3, 6));
        
        submissionEntrys2.add(new SubmissionEntry(sub1, 10));
        submissionEntrys2.add(new SubmissionEntry(sub2, 9));
        submissionEntrys2.add(new SubmissionEntry(sub3, 3));
        
        
        
        
        Submission student1Submission = new Submission(student1, submissionEntrys1);
        Submission sutdnet2Submission = new Submission(student2, submissionEntrys2);

        
        ArrayList<Submission> submissions = new ArrayList<>();
        submissions.add(student1Submission);
        submissions.add(sutdnet2Submission);
        ObjectWriter.writeObjects(submissions, "Submission");
        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        
        ArrayList<Teacher> teachers = new  ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);
        
        ObjectWriter.writeObjects(subjects, "Subject");
        ObjectWriter.writeObjects(teachers,"Teacher");
        ObjectWriter.writeObjects(students, "Student");
        
        Grammatia grammatia = new Grammatia("grammatiauser", "756984");
        ArrayList<Grammatia> grammatiaUsers = new ArrayList<>();
        grammatiaUsers.add(grammatia);
        ObjectWriter.writeObjects(grammatiaUsers, "Grammatia");  
          

    
    }
}
    
