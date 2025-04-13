/*
 * @file            SpringBoot/src/main/java/com/TaskController.java
 * @description     API controller
 * @author          Jesse Peterson
 * @createTime      2025-04-11 22:05:56
 * @lastModified    2025-04-12 19:10:17
*/

package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// Combines controller and response body
// Tells that this class handles http requests and its methods return data, not html views
@RestController
//Sets the base URL for all endpoints in this controller
@RequestMapping("/tasks")
public class TaskController {

    // inject an instance of TaskRepository into the field
    @Autowired
    private TaskRepository taskRepository;

    // Handles POST
    @PostMapping
    public Task createTask(@RequestBody Task task) { // Tells spring to take the body of the HTTP request and convert it to from JSON top java
        return taskRepository.save(task);
    }

    // Handlles GET
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Handles DELETE
    // ResponseEntity is a spring class that handles HTTP responses
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) { // Tells spring to take the value from the URL path and plug it into this method parameter

        // If the task exists then delete it
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            // create response entity with 204 response then build
            return ResponseEntity.noContent().build();
        } else {
            // create response entity with 404 response the build
            return ResponseEntity.notFound().build();
        }
    }


    
}
