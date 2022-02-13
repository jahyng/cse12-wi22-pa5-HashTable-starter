/**
 * TODO: Complete the solution for Student
 */
import java.util.Objects;

public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String PID;

    public Student(String firstName, String lastName, String PID) {
        if (firstName == null || lastName == null || PID == null) {
            throw new NullPointerException();
        }
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPID() {
        return PID;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
