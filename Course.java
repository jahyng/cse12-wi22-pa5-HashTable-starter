/**
 * TODO: Complete the solution for Course
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;

public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;

    public Course(String department, String number, String description, 
        int capacity){
            if (department == null || number == null || description == null) {
                throw new NullPointerException();
            }
            if (capacity < 0) {
                throw new IllegalArgumentException();
            }
            this.enrolled = new HashSet<Student>(0);
            this.department = department;
            this.number = number;
            this.description = description;
            this.capacity = capacity;
        }

    /**
     * fetch department name
     * @return department member variable
     */
    public String getDepartment(){
        return this.department;
    }

    /**
     * fetch course number
     * @return number member variable
     */
    public String getNumber(){
        return this.number;
    }

    /**
     * fetch desciption of course
     * @return description member variable
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * fetch capacity of course
     * @return capacity member variable
     */
    public int getCapacity(){
        return this.capacity;
    }

    public boolean enroll(Student student) {
        if (student == null) {
            throw new NullPointerException();
        }
        if (!this.isFull() && !this.enrolled.contains(student)) {
            this.enrolled.add(student);
            return true;
        }
        else return false;
    }

    public boolean unenroll(Student student) {
        if (student == null) {
            throw new NullPointerException();
        }
        if (this.enrolled.contains(student)) {
            this.enrolled.remove(student);
            return true;
        }
        else return false;
    }

    public void cancel() {
        this.enrolled.clear();
    }

    public boolean isFull() {
        return this.getAvailableSeats() == 0;
    }

    public int getEnrolledCount() {
        return this.enrolled.size();
    }

    public int getAvailableSeats() {
        return this.capacity - this.enrolled.size();
    }

    public HashSet<Student> getStudents() {
        return this.enrolled;
    }

    public ArrayList<Student> getRoster() {
        ArrayList<Student> rosterList = new ArrayList<Student>();
        //Iterator iter = this.enrolled.iterator();
        while (this.enrolled.iterator().hasNext()) {
            Student nextIter = this.enrolled.iterator().next();
            rosterList.add(nextIter);
        }
       
        return rosterList;
    }

    public String toString() {
        String result = String.format("%s %s [%s]\n%s", this.department, 
            this.number, this.capacity, this.description);
        return result;
    }
}

