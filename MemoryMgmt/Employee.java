package MemoryMgmt;

import java.lang.ref.Cleaner;

public class Employee{

    private static final Cleaner cleaner = Cleaner.create();
    private final Cleaner.Cleanable cleanable;
    
    private int id_;
    private String name;
    private String positon;


    /**
     * Constructor, initialize employee object
     * @param id_ (int)
     * @param name (String)
     * @param position (String)
     */
    Employee (int id_, String name, String position) {
        cleanable = cleaner.register(this, () -> {
            System.out.println("Cleaning Resources for Employee: " + id_);
        });

        this.id_ = id_;
        this.name = name;
        this.positon = position;
    }


    /**
     * Format the employee info
     * id, name and position
     */
    public String toString() {
        return "Id_: " + id_ + "\nName: " + name + "\nPosition: " + positon;
    }
}
