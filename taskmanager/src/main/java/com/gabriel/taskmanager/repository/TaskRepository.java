package com.gabriel.taskmanager.repository;

import com.gabriel.taskmanager.domain.Task;
import com.gabriel.taskmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByOwner(User owner);
}
