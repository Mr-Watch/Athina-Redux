package Controler;

import Model.Grammatia;
import Model.Request;
import Model.Student;
import Model.Subject;
import Model.Submission;
import Model.SubmissionEntry;
import Model.Teacher;
import Model.User;
import java.io.File;
import java.util.ArrayList;

public class Controler {

    private Student student;
    private Teacher teacher;
    private Grammatia grammatia;

    public Object validateUser(String userName, String userPassword, int userType) {
        ArrayList<User> userList = new ArrayList<>();
        switch (userType) {
            case (49):
                userList = ObjectReader.readObjects("Student");
                break;
            case (50):
                userList = ObjectReader.readObjects("Teacher");
                break;
            case (51):
                userList = ObjectReader.readObjects("Grammatia");
                break;
        }
        for (User user : userList) {
            if (user.checkLogIn(userName, userPassword)) {
                switch (user.getClass().toString().substring(12)) {
                    case "Student":
                        student = (Student) user;
                        break;
                    case "Teacher":
                        teacher = (Teacher) user;
                        break;
                    case "Grammatia":
                        grammatia = (Grammatia) user;
                        break;
                    default:
                        break;
                }
                return user;
            }
        }
        return null;
    }

    public ArrayList<String> getAllSubjectsStrings() {
        ArrayList<String> returnSubjects = new ArrayList<>();
        ArrayList<Subject> subjectsRead = ObjectReader.readObjects("Subject");

        for (Subject subject : subjectsRead) {
            returnSubjects.add(subject.toBasicString());
        }
        return returnSubjects;
    }

    public String getSubjectInfo(String selectedItem) {
        int subjectCode = Integer.parseInt(selectedItem.substring(selectedItem.indexOf("(") + 1, selectedItem.indexOf(")")));
        ArrayList<Subject> subjectsRead = ObjectReader.readObjects("Subject");

        for (Subject subject : subjectsRead) {
            if (subject.getSubjectCode() == subjectCode) {
                return subject.toStringFormated();
            }
        }
        return "Δεν βρέθηκαν πληρωφορίες για το μάθημα";
    }

    public ArrayList<String> getAllTeachersStrings() {
        ArrayList<String> returnTeachers = new ArrayList<>();
        ArrayList<Teacher> teachersRead = ObjectReader.readObjects("Teacher");

        for (Teacher teacher : teachersRead) {
            returnTeachers.add(teacher.toString());
        }
        return returnTeachers;
    }

    public boolean addNewSubject(String subjectName, String subjectDiscription, int subjectCode, int subjectEcts, int subjectSemmester, String teacher1, String teacher2) {
        ArrayList<String> returnTeachers = new ArrayList<>();
        ArrayList<Teacher> teachersRead = ObjectReader.readObjects("Teacher");
        ArrayList<Teacher> teachers = new ArrayList<>();
        Subject returedSubject;

        for (Teacher teacher : teachersRead) {
            if (teacher.toString().equals(teacher1) || teacher.toString().equals(teacher2)) {
                teachers.add(teacher);
            }
        }
        if (teachers.isEmpty()) {
            return false;
        }
        returedSubject = grammatia.addNewSubject(subjectName, subjectDiscription, subjectCode, subjectEcts, subjectSemmester, teachers);
        for (Teacher toModifyTeacher : teachersRead) {
            for (Teacher teacher : teachers) {
                if (teacher == toModifyTeacher) {
                    toModifyTeacher.addSubject(returedSubject);
                }
            }
        }

        ArrayList<Subject> readSubjects = ObjectReader.readObjects("Subject");
        readSubjects.add(returedSubject);

        ObjectWriter.writeObjects(ObjectWriter.removeDuplicates(readSubjects), "Subject");
        ObjectWriter.writeObjects(ObjectWriter.removeDuplicates(teachersRead), "Teacher");
        return true;
    }

    public ArrayList<String> getTeacherSubjects() {
        ArrayList<String> returnSubjects = new ArrayList<>();
        ArrayList<Subject> subjectsRead = ObjectReader.readObjects("Subject");

        for (Subject subject : subjectsRead) {
            for (Subject teachersSubject : teacher.getAllSubjects()) {
                if (subject.getSubjectName().equals(teachersSubject.getSubjectName())) {
                    returnSubjects.add(subject.getSubjectName());
                }
            }

        }
        return returnSubjects;
    }

    public ArrayList<String[]> getStudents(String subjectSelected) {
        ArrayList<Submission> submissions = ObjectReader.readObjects("Submission");
        ArrayList<String[]> students = new ArrayList<String[]>();

        for (Submission submission : submissions) {
            for (SubmissionEntry entry : submission.getSubmissionEntrys()) {
                if (subjectSelected.equals(entry.getSubject().getSubjectName())) {
                    String[] tempStudent = {submission.getSubmissionStudent().getUserName(), String.valueOf(entry.getSubjectGrade())};
                    students.add(tempStudent);
                }
            }
        }
        return students;
    }

    public void makeTeacherRequest(String studentName, String subjectName, float grade) {
        ArrayList<Request> requestsRead = ObjectReader.readObjects("Request");
        requestsRead.add(teacher.makeRequestToChangeGrade(teacher.getTeacherName(), studentName, subjectName, grade));
        ObjectWriter.writeObjects(requestsRead, "Request");
        ObjectWriter.writeObjects(requestsRead, "Request_log");
    }

    public ArrayList<String[]> getAllRequests() {
        ArrayList<Request> requestsRead = ObjectReader.readObjects("Request");
        ArrayList<String[]> returnRequest = new ArrayList<String[]>();

        for (Request request : requestsRead) {

            String[] requestString = request.toStringArray();
            returnRequest.add(requestString);
        }
        return returnRequest;
    }

    public void validateTeacherRequest(int selectedRequest, String teacherName, String studentName, String studentSubject, float studentGrade) {
        ArrayList<Submission> readSubmissions = ObjectReader.readObjects("Submission");
        ArrayList<Request> requestsRead = ObjectReader.readObjects("Request");
        requestsRead.remove(selectedRequest);
        ObjectWriter.writeObjects(requestsRead, "Request");
        for (Submission submission : readSubmissions) {
            if (submission.getSubmissionStudent().getUserName().equals(studentName)) {
                for (SubmissionEntry entry : submission.getSubmissionEntrys()) {
                    if (entry.getSubject().getSubjectName().equals(studentSubject)) {
                        entry = grammatia.validateTeacherRequest(entry, studentGrade);
                        break;
                    }
                }
            }
        }
        ObjectWriter.writeObjects(readSubmissions, "Submission");
    }

    public File getPdfFile() {
        return ObjectReader.getPdfFile();
    }

    public void setPdfPath(String path) {
        ObjectWriter.writePdfPath(path);
    }

    public ArrayList<String> getAllStudentSubjectsStrings() {
        ArrayList<String> returnSubjects = new ArrayList<>();
        ArrayList<Subject> subjectsRead = ObjectReader.readObjects("Subject");

        for (Subject subject : subjectsRead) {
            if((student.getStudentSummester()+1) == subject.getSubjectSemmester()){
                returnSubjects.add(subject.toBasicString());
            }
        }
        return returnSubjects;
    }

    public String[] getSelectedSubject(String selectedItem) {
        int subjectCode = Integer.parseInt(selectedItem.substring(selectedItem.indexOf("(") + 1, selectedItem.indexOf(")")));
        ArrayList<Subject> subjectsRead = ObjectReader.readObjects("Subject");

        for (Subject subject : subjectsRead) {
            if (subject.getSubjectCode() == subjectCode) {
                return subject.toTableString();
            }
        }
        String [] noMatch = {"Δεν βρέθηκε το μάθημα"};
        return noMatch;
    }

}
