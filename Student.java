//student class
package studentscore;

public class Student {
    private String name;
    private int rollNo;
    private int marks;

    public Student(String name, int rollNo, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + "," + rollNo + "," + marks;
    }
}
