package stringsAndCollections;


public class Main {

    

    public static void main (String[] args) {
        TaskKeeper toDoList = TaskKeeper.getInstance();

        System.out.println("Adding Tasks...");

        toDoList.addTasks("Clean Room", "Jesse", "Personal");
        toDoList.addTasks("Wash The Cars", "Jesse", "Personal");
        toDoList.addTasks("Free The Dogs", "Jesse", "Personal");

        toDoList.addTasks("Complete Java Fundementals Practice", "Jesse", "Work");
        toDoList.addTasks("Complete Job Applications", "Jesse", "Work");
        toDoList.addTasks("Fix Github Action for Protfolio", "Jesse", "Work");
        toDoList.addTasks("Optimize Asset loading for Portfolio", "Jesse", "Work");

        System.out.println("\nDisplaying Tasks...");
        System.out.println("-------------------------------");


        toDoList.displayTasks();

        System.out.println("\nRemoving Task...");

        System.out.println(toDoList.removeTasks(2) ? "Success" : "Task Not Found");

        System.out.println("\nDisplaying Tasks...");
        System.out.println("-------------------------------");


        toDoList.displayTasks(); 

        System.out.println("\nSorting Tasks...");

        toDoList.sortTasks();

        System.out.println("\nDisplaying Tasks...");
        System.out.println("-------------------------------");

        toDoList.displayTasks();

        System.out.println("\nCategorizing Tasks by Type");
        System.out.println("-------------------------------");

        toDoList.categorizeTasks();

    }
}
