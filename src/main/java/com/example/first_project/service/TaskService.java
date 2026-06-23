package com.example.first_project.service;

import com.example.first_project.repository.TaskRepository;
import org.springframework.stereotype.Service;
import com.example.first_project.entity.Task;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task now found"));
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
