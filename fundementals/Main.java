package fundementals;

import java.util.ArrayList; 
import java.util.regex.*;

class Main {

    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Adding Students...");
        addStudentToArray(1, "JAMES", (float)2.5);
        addStudentToArray(2, "bri", (float)4.0);
        addStudentToArray(3, "jOhn", (float)3.6);


        System.out.println("\nFinding Student Number 1...");
        findStudent(1);

        System.out.println("\nPrinting All Students...");
        printStudents();

        System.out.println("\nRemoving Student Number 1...");
        removeStudent(1);

        System.out.println("\nPrinting All Students...");
        printStudents();
    }


    /**
     * Creates a new student object and adds the student to the array
     * @param id
     * @param name
     * @param grade
     */
    private static void addStudentToArray(int id, String name, float grade) {
        Student student = new Student(id, formatName(name), grade);
        students.add(student);
    }

    private static String formatName(String name) {
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }


    /**
     * Finds a student from the arraylist who has a matching id
     * @param id
     */
    private static void findStudent(int id) {
        
        for (Student student : students) {

            Object studentId = student.getStudent().get(0);


            if (studentId instanceof Integer) {
                Integer num = (Integer) studentId;
                if (num == id) {
                    System.out.println(student);
                }
            }

            
        }
    }

    /**
     * Removes student from the arraylist who has a matching studentID
     * @param id
     * @return
     */
    private static boolean removeStudent(int id) {
        
        for (Student student : students) {

            Object studentId = student.getStudent().get(0);

            if (studentId instanceof Integer) {
                Integer num = (Integer) studentId;
                if (num == id) {
                    students.remove(student);
                    return true;
                }
            }
        }

        return false;
        
    }


    /**
     * Prints all of the students in the array
     */
    private static void printStudents() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

}