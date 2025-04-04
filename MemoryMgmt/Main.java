package MemoryMgmt;

import java.util.ArrayList;
import java.util.List;

class Main{
    
    public static void main(String[] args) {

        // Create a scoped block to lose references
        {

            List<Employee> employees = new ArrayList<Employee>();
            for(int i = 0; i < 10; i++) {
                employees.add(new Employee(i, null, null));
            }

            employees.clear();

        }

        // Suggest a gc
        System.gc();


        // Wait to give Cleaner thread time to run
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            System.err.println(e);
        } 
        

        System.out.println("Main thread done.");


    } 
}
