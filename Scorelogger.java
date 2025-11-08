package studentscore;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreLogger {
    private final String filePath;

    public ScoreLogger(String filePath) {
        this.filePath = filePath;
    }

    // Thread-safe writing
    public synchronized void logScore(Student student) throws IOException {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write(student.toString() + "\n");
        }
        // Display the student name in console
        System.out.println("Logged: " + student.toString());
    }
}


