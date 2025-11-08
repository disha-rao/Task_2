
package studentscore;
public class StudentThread extends Thread {
    private final ScoreLogger logger;
    private final Student student;

    public StudentThread(ScoreLogger logger, Student student) {
        this.logger = logger;
        this.student = student;
    }

    @Override
    public void run() {
        try {
            logger.logScore(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


