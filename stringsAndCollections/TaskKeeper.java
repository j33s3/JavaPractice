package stringsAndCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TaskKeeper {

    // The one and only instance for the taskKeeper
    private static TaskKeeper instance = new TaskKeeper();


    // Returns The one and only instance for the taskKeeper
    public static TaskKeeper getInstance() {
        return instance;
    }

    // ArrayList field for storing tasks
    private ArrayList<Task> tasks = new ArrayList<>();

    //Changing field
    private int id_ = 10;

    /**
     * Default Empty Constructor
     */
    private TaskKeeper() {}
    

    /**
     * Method for adding tasks to the array list
     * @param taskDesc
     * @param taskOp
     * @param taskType
     */
    public void addTasks(String taskDesc, String taskOp, String taskType) {
        Task task = new Task(id_, taskDesc, taskOp, taskType);
        tasks.add(task);
        id_ -= 1;
    }


    /**
     * Removes A Task From the ArrayList
     * @param id_
     * @return
     */
    public boolean removeTasks(int id_) {
        for (Task task : tasks) {
            
            //if id is an integer set then cast it
            if (task.getTask().get(0) instanceof Integer) {
                Integer num = (Integer)task.getTask().get(0);
                
                // if the id is a match, remove task;
                if (num == id_) {
                    tasks.remove(task);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Displays all Tasks
     */
    public void displayTasks() {
        for (Task task : tasks) {

            System.out.println(task.toString());

            if(task != tasks.getLast()) {
                System.out.println();
            }
        }
    }

    /**
     * Sorts tasks based on their ID
     */
    public void sortTasks() {
        Collections.sort(tasks);
    }


    /**
     * Categorizes Tasks based on their types
     */
    public void categorizeTasks() {
        Map<String, List<Task>> categorizedTasks = new HashMap<>();


        // Adds tasks to the map
        for (Task task : tasks) {
            String category = (String)task.getTask().get(3);
            categorizedTasks.putIfAbsent(category, new ArrayList<>());
            categorizedTasks.get(category).add(task);
        }

        // Prints tasks
        categorizedTasks.forEach((category, items) -> {
            System.out.println(category);
            for(Task item : items) {
                System.out.println(item.toString());
                System.out.println();
            }
        });
    }

}
