package com.gabriel.taskmanager.service;

import com.gabriel.taskmanager.domain.Task;
import com.gabriel.taskmanager.domain.User;
import com.gabriel.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }
}
