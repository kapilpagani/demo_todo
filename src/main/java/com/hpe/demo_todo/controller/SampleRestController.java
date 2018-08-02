package com.hpe.demo_todo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hpe.demo_todo.model.Task;
import com.hpe.demo_todo.service.TaskService;

@RestController
public class SampleRestController {
    
    @Autowired
    private TaskService taskService;
    
    @RequestMapping("/ex-All-Task")
    public String extractALlTast(HttpServletRequest request) {
        return taskService.findAll().toString();
    }

    @RequestMapping("/ex-Add-Task")
    public String AddTask(@RequestParam String name, @RequestParam String desc) {
        Task task = new Task(name, desc, new Date(), false);
        taskService.save(task);
        return "Task Saved";
    }
}
