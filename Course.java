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
            this.department = department;
            this.number = number;
            this.description = description;
        }

    public String getDepartment(){
        return this.department;
    }

    public String getNumber(){
        return this.number;
    }

    public String getDescription(){
        return this.description;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public boolean enroll(Student student) {
        if (student == null) {
            throw new NullPointerException();
        }
        if (this.enrolled.size() < this.capacity)
    }

    public boolean unenroll(Student student) {
        return false;
    }

    public void cancel() {}

    public boolean isFull() {
        return false;
    }

    public int getEnrolledCount() {
        return 0;
    }

    public int getAvailableSeats() {
        return 0;
    }

    public HashSet<Student> getStudents() {
        return null;
    }

    public ArrayList<Student> getRoster() {
        ArrayList rosterList = new ArrayList<Student>();
        for (int i = 0; i < this.number; i++) {
            rosterList[i] = this[i];
        } 
        return rosterList;
    }

    public String toString() {
        return null;
    }
}

