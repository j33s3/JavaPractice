/*
 * @file            SpringBoot/src/main/java/com/Task.java
 * @description     Task object, stores task information (id, description)
 * @author          Jesse Peterson
 * @createTime      2025-04-11 22:05:56
 * @lastModified    2025-04-11 20:07:42
*/

package com;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


// Entity marks the class as a JPA entity
// Tells spring to treat this class as a table in the database
@Entity
public class Task {

    //Marks the field id as the primary key
    @Id
    //tells JPA to auto-generate the value of id
    @GeneratedValue
    private Long id;
    private String description;

    public Task() {}

    public Task(String description) {
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
