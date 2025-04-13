package com;

import org.springframework.data.jpa.repository.JpaRepository;


// Custom interface for interacting with Task data
// <Task: the entity this repository works with
// Long>: the type of primary key (@Id) in the Task class

// the super class provides, save, findall, findById, deleteById and existsById.
public interface TaskRepository extends JpaRepository<Task, Long> {
}
