/**
 * Name: Josh Yang
 * ID: A16667394
 * Email: jwyang@ucsd.ued
 * Sources used: None
 * Tester for methods that public tester did not test. 
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * This class tests methods that public test file did not. Public tester did not 
 * test exceptions, so this class does. 
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {

    // ----------------Student class----------------
    /**
     * Test the equals method when the method should return false
     */
    @Test
    public void testEquals() {
        Student student1 = new Student(new String("Test"), 
            new String("Student"), new String("A14"));
        Student student2 = new Student(new String("Test"), 
            new String("Student"), new String("A12345678"));
        assertFalse(student1.equals(student2));
        assertFalse(student1.equals(null));
    }

    /**
     * Test the compareTo method when [TODO]
     */
    @Test
    public void testCompareTo() {
        Student student1 = new Student(new String("Test"), 
        new String("Student"), new String("A12345678"));
        Student student2 = new Student(new String("Test"), 
            new String("Student"), new String("A12345678"));
        Student student3 = new Student(new String("Test"), 
            new String("Student"), new String("A122"));

        assertEquals(0, student1.compareTo(student2));
        assertEquals(1, student1.compareTo(student3));
        assertEquals(-1, student3.compareTo(student1));
    }

    // ----------------Course class----------------
    /**
     * Test the enroll method when [TODO]
     */
    @Test
    public void testEnroll() {
        Course course = new Course("CSE", "12", "Data Structure", 3);
        course.enrolled = new HashSet<>();
        boolean exceptionThrown = false;
        
        try {
            course.enroll(null);
        }
        catch (NullPointerException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);

        // fill in the course

        course.enrolled.add(new Student("Whales1", "Ocean", "A123"));
        course.enrolled.add(new Student("Whales2", "Ocean", "A123"));
        course.enrolled.add(new Student("Whales3", "Ocean", "A123"));
        
        // create new student with same values as whales1
        Student whale = new Student("Whales1", "Ocean", "A123");
        assertEquals(false, course.enroll(whale));

        // create new student 
        Student student1 = new Student(new String("Test"), 
            new String("Student"), new String("A12345678"));
        assertEquals(false, course.enroll(student1));
    }

    /**
     * Test the unenroll method when [TODO]
     */
    @Test
    public void testUnenroll() {
        Course course = new Course("CSE", "12", "Data Structure", 1);
        course.enrolled = new HashSet<>();
        boolean exceptionThrown = false;
        
        try {
            course.unenroll(null);
        }
        catch (NullPointerException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);

        
        // fill in the course

        Student test = new Student("Josh", "Yang", "A111");
        assertEquals(false, course.unenroll(test));
        course.enrolled.add(test);
        assertEquals(true, course.unenroll(test));
        assertEquals(0, course.enrolled.size());




    }

    /**
     * Test the getRoster method when [TODO]
     */
    @Test
    public void testGetRoster() {
        Course course = new Course("CSE", "12", "Data Structure", 3);
        course.enrolled = new HashSet<>();
        Student test = new Student("Josh", "Yang", "A111");
        Student test2 = new Student("Joey", "Yang", "A112");
        Student test3 = new Student("Matt", "Yang", "A113");
        course.enrolled.add(test);
        course.enrolled.add(test2);
        course.enrolled.add(test3);

        ArrayList <Student> list = course.getRoster();

        assertEquals(3, course.getRoster().size());
        assertEquals(test2, list.get(0));
        assertEquals(test, list.get(1));
        assertEquals(test3, list.get(2));
    
    }

    // ----------------Sanctuary class----------------
    /**
     * Test the constructor when [TODO]
     */
    @Test
    public void testSanctuaryConstructor() {
        boolean exceptionThrown = false;
        try {
            Sanctuary scripps = new Sanctuary(-1, 10);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);

        exceptionThrown = false;

        try {
            Sanctuary giesel = new Sanctuary(9, -6);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);

        Sanctuary sanct = new Sanctuary(0, 0);
        assertEquals(0, sanct.maxAnimals);
        assertEquals(0, sanct.maxSpecies);
    }

    /**
     * Test the rescue method when [TODO]
     */
    @Test
    public void testRescueTestOne(){
        Sanctuary sanct = new Sanctuary(100, 2);
        assertEquals(0, sanct.rescue("largies", 10));
        assertTrue(sanct.sanctuary.containsKey("largies"));
        assertEquals(10, (int) sanct.sanctuary.get("largies"));

        // add more largies
        assertEquals(0, sanct.rescue("largies", 10));
        assertEquals(20, (int) sanct.sanctuary.get("largies"));
        assertEquals(20, sanct.getTotalAnimals());
        assertEquals(1, sanct.getTotalSpecies());

        assertEquals(0, sanct.rescue("spotties", 10));
        assertEquals(30, sanct.getTotalAnimals());
        // should not be able to add another species
        assertEquals(0, sanct.rescue("smallies", 8));
        assertFalse(sanct.sanctuary.containsKey("smallies"));

    }

    /**
     * Test the rescue method when [TODO: fill in another one here]
     */
    @Test
    public void testRescueTestTwo(){
        Sanctuary sanct = new Sanctuary(20, 2);
        sanct.rescue("largies", 10);
        assertEquals(5, sanct.rescue("largies", 15));
        assertEquals(20, (int) sanct.sanctuary.get("largies"));
        assertEquals(sanct.maxAnimals, sanct.getTotalAnimals());
        assertEquals(0, sanct.rescue("smallies", 9));
        assertFalse(sanct.sanctuary.containsKey("smallies"));
    }

    /**
     * Test the release method when an excepetion should be thrown
     */
    @Test
    public void testReleaseTestOne(){        
        Sanctuary sanct = new Sanctuary(20, 1);
        boolean excepetionThrown = false;
        sanct.rescue("largies", 20);

        // release species that does not exist
        try {
            sanct.release("smallies", 5);
        }
        catch (IllegalArgumentException e) { 
            excepetionThrown = true;
        }
        assertTrue(excepetionThrown);
        // reset exceptionThrown
        excepetionThrown = false;

        // release with invalid num param
        try {
            sanct.release("largies", -9);
        }
        catch (IllegalArgumentException e) {
            excepetionThrown = true;
        }
        assertTrue(excepetionThrown);
        // reset exceptionThrown
        excepetionThrown = false;

        // release too many of species
        try {
            sanct.release("largies", 30);
        }
        catch (IllegalArgumentException e) {
            excepetionThrown = true;
        }
        assertTrue(excepetionThrown);
        // reset exceptionThrown
        excepetionThrown = false;

        // release null species
        try {
            sanct.release(null, 4);
        }
        catch (IllegalArgumentException e) {
            excepetionThrown = true;
        }
        assertTrue(excepetionThrown);
        // reset exceptionThrown
        excepetionThrown = false;
    }

    /**
     * Test the release method when an entire species gets released
     */
    @Test
    public void testReleaseTestTwo(){
        Sanctuary sanct = new Sanctuary(20, 2);
        sanct.rescue("largies", 10);
        sanct.rescue("smallies", 10);
        // release largies
        sanct.release("largies", 10);
        assertFalse(sanct.sanctuary.containsKey("largies"));
        assertEquals(10, sanct.getTotalAnimals());
        assertEquals(1, sanct.getTotalSpecies());
        assertEquals(1, sanct.sanctuary.size());

        // release smallies
        sanct.release("smallies", 10);
        assertFalse(sanct.sanctuary.containsKey("smallies"));
        assertEquals(0, sanct.getTotalAnimals());
        assertEquals(0, sanct.getTotalSpecies());
        assertEquals(0, sanct.sanctuary.size());
    }
}

