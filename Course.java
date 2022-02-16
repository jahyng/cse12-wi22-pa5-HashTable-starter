/**
 * Josh yang
 * A16667394
 * jwyang@ucsd.edu
 * I used the link to the java site on hashset implementation. 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * This class creates hashset of students for a course. For instance variables,
 * there is one int and three strings. The int is the capacity of course. The 
 * string department gives the department of course, number gives the course 
 * number, descpriton gives gives a description of the course. 
 */
public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;

    /**
     * contructor for course
     * @param department department of course
     * @param number course number
     * @param description course description
     * @param capacity capacity of course
     */
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

    /**
     * adds new student to course if situation allows for it
     * @param student studnet that will be added
     * @return true if student is succesfully enrolled, false if not
     */
    public boolean enroll(Student student) {
        if (student == null) {
            throw new NullPointerException();
        }
        if (!this.isFull() && !this.enrolled.contains(student)) {
            this.enrolled.add(student);
            // check if student is successfully added
            return this.enrolled.contains(student);
        }
        else return false;
    }

    /**
     * removes student from the course
     * @param student student that will be removed
     * @return true if student is successfully removed, false otherwise
     */
    public boolean unenroll(Student student) {
        if (student == null) {
            throw new NullPointerException();
        }
        if (this.enrolled.contains(student)) {
            this.enrolled.remove(student);
            // check if student is successfully removed
            return !this.enrolled.contains(student);
        }
        else return false;
    }

    /**
     * clear all students from course
     */
    public void cancel() {
        this.enrolled.clear();
    }

    /**
     * determines if course is full 
     * @return true if course is full, false if not
     */
    public boolean isFull() {
        return this.getAvailableSeats() == 0;
    }

    /**
     * gets number of students enrolled in course
     * @return size of enrolled hashset
     */
    public int getEnrolledCount() {
        return this.enrolled.size();
    }

    /**
     * gets number of available seats for course
     * @return number of available seats
     */
    public int getAvailableSeats() {
        return this.capacity - this.enrolled.size();
    }

    /**
     * gets shallow copy of enrolled hashset
     * @return shallow copy of hashset
     */
    public HashSet<Student> getStudents() {
        return this.enrolled;
    }

    /**
     * gets arraylist of students enrolled in course and sorts them according to 
     * compareTo() method
     * @return arrayList of students that's sorted
     */
    public ArrayList<Student> getRoster() {
        ArrayList<Student> rosterList = new ArrayList<Student>();
        // for every student in hashset
        for (Student stu : this.enrolled) {
            rosterList.add(stu);
        }
        // sort list
        Collections.sort(rosterList);
        return rosterList;
    }

    /**
     * gives formated string 
     * @return formatted string
     */
    public String toString() {
        String result = String.format("%s %s [%s]\n%s", this.department, 
            this.number, this.capacity, this.description);
        return result;
    }
}

