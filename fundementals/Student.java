package fundementals;

import java.util.Arrays;
import java.util.List;

class Student {

    int id;
    String name;
    float grade;

    /**
     * constructor for the student object
     * @param id
     * @param name
     * @param grade
     */
    Student(int id, String name, float grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }


    /**
     * returns the contents of the student as an object for mixed datatypeing
     * @return
     */
    public List<Object> getStudent() {
        return Arrays.asList(id, name, grade);
    }


    /**
     * formats the student as ID, Name, Grade
     */
    public String toString() {
        return "ID: " + id + " NAME: " + name + " GRADE: " + grade;
    }

}