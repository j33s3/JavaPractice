/*
 * @file            SpringBoot/src/main/java/com/TaskRepository.java
 * @author          Jesse Peterson
 * @createTime      2025-04-11 22:05:56
 * @lastModified    2025-04-12 19:13:22
*/

package com;

import org.springframework.data.jpa.repository.JpaRepository;


// Custom interface for interacting with Task data
// <Task: the entity this repository works with
// Long>: the type of primary key (@Id) in the Task class

// the super class provides, save, findall, findById, deleteById and existsById.
public interface TaskRepository extends JpaRepository<Task, Long> {
}
