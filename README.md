# Java Learning Assignments

## 1. Core Java Fundamentals  
### **Prompt:** Implement a basic **Student Management System**  
✅ **Requirements:**  
- Create a `Student` class with `id`, `name`, and `grade`.  
- Store students in an array and allow adding, removing, and searching students.  
- Implement methods for string manipulation (e.g., format student names properly).  
- Use loops to display all students.  

---

## 2. String Manipulation  
### **Prompt:** Create a **Text Formatter**  
✅ **Requirements:**  
- Ask the user to input a paragraph.  
- Implement methods to:  
  - Convert all text to lowercase.  
  - Count the number of words.  
  - Replace all spaces with underscores.  
- Use `StringBuilder` for efficient string handling.  

---

## 3. Arrays & Collections  
### **Prompt:** Implement a **To-Do List**  
✅ **Requirements:**  
- Use an `ArrayList<String>` to store tasks.  
- Allow users to add, remove, and display tasks.  
- Sort tasks alphabetically using `Collections.sort()`.  
- Use a `HashMap` to categorize tasks (e.g., `work`, `personal`).  

---

## 4. Object-Oriented Programming (OOP)  
### **Prompt:** Build an **E-commerce System**  
✅ **Requirements:**  
- Create a base `Product` class with `name`, `price`, and `stock`.  
- Create `Electronics` and `Clothing` subclasses that extend `Product`.  
- Implement a method `calculateDiscount()` that behaves differently in both subclasses.  
- Demonstrate encapsulation using private fields with getters and setters.  

---

## 5. Exception Handling  
### **Prompt:** Implement a **Banking System with Error Handling**  
✅ **Requirements:**  
- Create an `Account` class with methods `deposit(double amount)` and `withdraw(double amount)`.  
- If a withdrawal exceeds balance, throw a `CustomInsufficientFundsException`.  
- Use try-catch blocks to handle user input errors.  

---

## 6. Java Memory Management & Performance  
### **Prompt:** Simulate a **Garbage Collection Scenario**  
✅ **Requirements:**  
- Create objects inside a loop to simulate memory allocation.  
- Use `Cleaner` to register the object with a message when objects are garbage-collected.  
- Explicitly call `System.gc()` and observe the effect.  

---

## 7. Multithreading & Concurrency  
### **Prompt:** Create a **Multithreaded Download Manager**  
✅ **Requirements:**  
- Simulate downloading three files using separate threads.  
- Use `Thread.sleep()` to simulate different download times.  
- Implement a `synchronized` method to log the completed downloads.  

---

## 8. File Handling & I/O  
### **Prompt:** Build a **Simple Notepad**  
✅ **Requirements:**  
- Allow users to type and save text to a file.  
- Implement a method to read and display the file contents.  
- Use `BufferedReader` and `BufferedWriter` for efficiency.  

---

## 9. Java 8+ Features (Lambdas & Streams)  
### **Prompt:** Implement a **Data Filtering System**  
✅ **Requirements:**  
- Store a list of `Employee` objects (`name`, `age`, `salary`).  
- Use **Streams API** to:  
  - Filter employees earning more than $50,000.  
  - Sort employees by salary.  
- Use a **lambda expression** to define a custom sorting function.  

---

## 10. Database & JDBC  
### **Prompt:** Create a **Simple Employee Database**  
✅ **Requirements:**  
- Connect to a MySQL database using **JDBC**.  
- Allow users to **add, delete, update, and view employees** in the database.  
- Use **PreparedStatement** to prevent SQL injection.  

---

## 11. Web Development with Java (Spring Boot)  
### **Prompt:** Develop a **REST API for a Task Manager**  
✅ **Requirements:**  
- Use **Spring Boot** to create an API with endpoints:  
  - `POST /tasks` (Create a new task)  
  - `GET /tasks` (Retrieve all tasks)  
  - `DELETE /tasks/{id}` (Delete a task)  
- Use an in-memory **H2 database** to store tasks.  
- Return JSON responses.  

