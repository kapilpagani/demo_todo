package com.hpe.demo_todo.dao;

import org.springframework.data.repository.CrudRepository;

import com.hpe.demo_todo.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}
