package studentscore;
public class Main {
    public static void main(String[] args) {
        String filePath = "scores.csv";
        ScoreLogger logger = new ScoreLogger(filePath);

        // 3 students
        Student s1 = new Student("Riya", 1001, 85);
        Student s2 = new Student("Jhon", 1002, 92);
        Student s3 = new Student("Geetha", 1003, 79);

        // 3 threads writing concurrently
        Thread t1 = new StudentThread(logger, s1);
        Thread t2 = new StudentThread(logger, s2);
        Thread t3 = new StudentThread(logger, s3);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All the student scores logged successfully!!");
    }
}
