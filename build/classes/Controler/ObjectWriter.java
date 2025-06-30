package Controler;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class ObjectWriter {

    static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        Set<T> set = new LinkedHashSet<>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    public static <T> void writeObjects(ArrayList<T> objects, String className) {
        String filePath = "";
        switch (className) {
            case "Student":
                filePath = "./src/Database/Students/Students.aof";
                break;
            case "Subject":
                filePath = "./src/Database/Subjects/Subjects.aof";
                break;
            case "Teacher":
                filePath = "./src/Database/Teachers/Teachers.aof";
                break;
            case "Grammatia":
                filePath = "./src/Database/Grammatia/Grammatia.aof";
                break;
            case "Submission":
                filePath = "./src/Database/Submissions/Submissions.aof";
                break;
            case "Request":
                filePath = "./src/Database/Requests/Requests.aof";
                break;
            case "Request_log":
                filePath = "./src/Database/Requests/Requests_log.aof";
                break;
            default:
                break;
        }
        try (FileOutputStream fos = new FileOutputStream(filePath);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(objects);
            fos.close();
            oos.close();
        } catch (FileNotFoundException ex) {
            System.err.println("The file was not found");
        } catch (IOException ex) {
            System.err.println("There was a problem with the IO");

        }
    }

    static void writePdfPath(String path) {
        try {
            FileOutputStream outputStream = new FileOutputStream("PdfPath.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            try (BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
                bufferedWriter.write(path);
            }
        } catch (IOException ex) {
            System.err.println("There was a problem with the IO");
        }
    }
}
