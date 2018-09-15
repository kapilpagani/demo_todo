package com.hpe.demo_todo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hpe.demo_todo.model.Task;
import com.hpe.demo_todo.service.JokeServiceImpl;
import com.hpe.demo_todo.service.TaskService;

@Controller
public class MainController {
    @Autowired private TaskService taskService;

    @Autowired private JokeServiceImpl jokeService;

    @RequestMapping("/")
    public String home(HttpServletRequest request) {

        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @RequestMapping("/all-tasks")
    public String allTasks(HttpServletRequest request) {
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }

    @RequestMapping("/new-task")
    public String newTask(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }

    @RequestMapping("/delete-task")
    public String deleteTask(@RequestParam int id, HttpServletRequest request) {
        taskService.delete(id);
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }

    @RequestMapping("/update-task")
    public String updateTask(@RequestParam int id, HttpServletRequest request) {

        request.setAttribute("task", taskService.findTask(id));
        request.setAttribute("mode", "MODE_UPDATE");
        return "index";
    }

    @RequestMapping("/save-task")
    public String saveTask(@ModelAttribute Task task, BindingResult bindingresult, HttpServletRequest request) {
        task.setDateCreated(new Date());
        taskService.save(task);
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }

    @RequestMapping("/joke")
    public String joke(Model model) {

        model.addAttribute("jokes", jokeService.joke());
        return "joke";
    }

    @RequestMapping({ "/receip1", "/receip2" })
    public String receipe() {
        return "rec";
    }

}
