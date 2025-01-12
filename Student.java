/**
 * Josh Yang
 * A16667394
 * jwyang@ucsd.edu
 * I used the links provided in the PA writeup for the implementation of 
 * hashCode and compareTo methods. 
 */
import java.util.Objects;

/**
 * This class creates student for the course. It overrides hashCode and 
 * compareTo methods. There are three String instance variables firstName, 
 * lastName, and PID.
 */
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
        if (o == null) {
            return false;
        }

        // type cast o to Student object
        Student test = (Student) o;

        // check if the instance vars are the same
        return test.getLastName().equals(this.getLastName())
            && test.getFirstName().equals(this.getFirstName()) 
            && test.getPID().equals(this.getPID());
           
        
      

    }

    /**
     * gives hashcode for the student object
     * @return student hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.firstName,this.lastName,this.PID);
    }

    /**
     * compares the student's instance variables
     * @param o student object used to compare
     * @return positive int if current student is lexicographically after param.
     * negative int if current student is lexicographically before param
     * 0 if students are the same
     */
    @Override
    public int compareTo(Student o) {
        // check last name first
        if (this.getLastName().compareTo(o.lastName) == 0) {
            // chekc first name next
            if (this.getFirstName().compareTo(o.firstName) == 0) {
                // check PID next
                if (this.getPID().compareTo(o.PID) == 0) {
                    return 0;
                }
                else return this.getPID().compareTo(o.PID);
            }
            else return this.getFirstName().compareTo(o.firstName);
        }
        else return this.getLastName().compareTo(o.lastName);
    }
}
