package Controler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectReader {

    public static <T> ArrayList<T> readObjects(String className) {
        ArrayList<T> objectsRead = new ArrayList<>();
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
            default:
                break;
        }
        try (FileInputStream fis = new FileInputStream(filePath);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            objectsRead = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            System.err.println("The file was not found");
        } catch (IOException ex) {
            System.err.println("There was a problem with the IO");
        } catch (ClassNotFoundException ex) {
            System.err.println("The class was not found");
        }
        return objectsRead;
    }

    static File getPdfFile() {
        File returnFile = null;
        try {
            try (FileReader reader = new FileReader("PdfPath.txt")) {
                BufferedReader bufferedReader = new BufferedReader(reader);
                String path;
                while ((path = bufferedReader.readLine()) != null) {
                    returnFile = new File(path);
                }
            }

        } catch (IOException e) {
            System.err.println("There was a problem with the IO");
        }
        return returnFile;
    }
}
