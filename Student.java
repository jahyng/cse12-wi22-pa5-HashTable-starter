/**
 * TODO: Complete the solution for Student
 */
import java.util.Objects;

public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String PID;

    /**
     * Constructor for student. Throws NullPointerException if any of the params
     * are null.
     * @param firstName first name of student
     * @param lastName last name of student
     * @param PID PID of student
     */
    public Student(String firstName, String lastName, String PID) {
        // check if any params are null
        if (firstName == null || lastName == null || PID == null) {
            throw new NullPointerException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.PID = PID;
    }

    /**
     * fetches last name of student
     * @return lastName member variable
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Fetches first name of student.
     * @return firstName member variable
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Fetches PID of student
     * @return PID member variable
     */
    public String getPID() {
        return this.PID;
    }

    @Override
    public boolean equals(Object o) {
        // check if o is null
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Student test = (Student) o;
        // check if the instance vars are the same
            return test.getLastName() == this.getLastName() && test.getFirstName() == this.getFirstName() && test.getPID() == this.getPID();
           
        
      

    }

    @Override
    public int hashCode() {
        return (int) hash(this.firstName, this.lastName, this.PID);
    }

    @Override
    public int compareTo(Student o) {
        if (o.getFirstName() == this.firstName && o.getLastName() == this.lastName && o.getPID() == this.PID) {
            return 0;
        }
        else if (o.hashCode() )
    }
}
