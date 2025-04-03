package stringsAndCollections;

import java.util.Arrays;
import java.util.List;

public class Task implements Comparable<Task>{

    // Class fields
    private int id_;
    private String taskDesc;
    private String taskOp;
    private String taskType;


    Task(int id_, String taskDesc, String taskOpp, String taskType){
        this.id_ = id_;
        this.taskDesc = taskDesc;
        this.taskOp = taskOpp;
        this.taskType = taskType;
    }


    public List<Object> getTask() {
        return Arrays.asList(id_, taskDesc, taskOp, taskType);
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.id_, other.id_);
    }
    
    @Override
    public String toString() {
        return "ID: " + id_ + "\nDescription: " + taskDesc + "\nTask Operator: " + taskOp + "\nTask Type: " + taskType; 
    }
}
