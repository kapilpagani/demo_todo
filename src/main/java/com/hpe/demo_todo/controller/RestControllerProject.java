package com.hpe.demo_todo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hpe.demo_todo.model.Task;
import com.hpe.demo_todo.service.TaskService;

@RestController
public class RestControllerProject {
    
    @Autowired
    private TaskService taskService;
    
    /*@RequestMapping("/all-tasks")    
    public String findAll(){
          return taskService.findAll().toString();
    }
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
    
    @RequestMapping("/save-task")
    public String save(@RequestParam String name, @RequestParam String desc) {
        
        Task task = new Task(name, desc, new Date(), false);
        taskService.save(task);
        
        return "Saved";
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam int id) {
        taskService.delete(id);
        return "Task Deleted";
    }
   
*/
}
