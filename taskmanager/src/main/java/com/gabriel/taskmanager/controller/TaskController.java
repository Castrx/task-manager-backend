package com.gabriel.taskmanager.controller;

import com.gabriel.taskmanager.domain.Task;
import com.gabriel.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> listAll() {
        return taskService.listAll();
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskService.create(task);
    }
}
