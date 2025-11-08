package studentscore;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreLoggerTest {

    private static final String TEST_FILE = "test_scores.csv";
    private ScoreLogger logger;

    @BeforeEach
    public void setup() {
        logger = new ScoreLogger(TEST_FILE);
    }

    @AfterEach
    public void cleanup() throws IOException {
        // Delete test file after each test to start fresh
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    // ✅ Test: File write logic and thread completion
    @Test
    public void testFileWriteAndThreadCompletion() throws InterruptedException, IOException {
        // 2 students for concurrent writing
        Student s1 = new Student("Dev", 302, 88);
        Student s2 = new Student("Emma", 303, 95);

        // 2 threads writing to the same file
        Thread t1 = new StudentThread(logger, s1);
        Thread t2 = new StudentThread(logger, s2);

        // Start threads
        t1.start();
        t2.start();

        // Wait for threads to finish (thread completion)
        t1.join();
        t2.join();

        // Verify file content (file write logic)
        String content = Files.readString(Paths.get(TEST_FILE));
        assertTrue(content.contains("Dev,302,88"), "File should contain David's data");
        assertTrue(content.contains("Emma,303,95"), "File should contain Eva's data");

        // Console output will show:
        // Logged: Dev,302,88
        // Logged: Emma,303,95
    }
}



