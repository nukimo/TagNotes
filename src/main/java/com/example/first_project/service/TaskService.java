package com.example.first_project.service;

import com.example.first_project.dto.TaskRequestDto;
import com.example.first_project.entity.Tag;
import com.example.first_project.repository.TagRepository;
import com.example.first_project.repository.TaskRepository;
import org.springframework.stereotype.Service;
import com.example.first_project.entity.Task;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TagRepository tagRepository;

    public TaskService(TaskRepository taskRepository, TagRepository tagRepository) {
        this.taskRepository = taskRepository;
        this.tagRepository = tagRepository;
    }

    public Task createTask(TaskRequestDto dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCreatedAt(LocalDateTime.now());

        Set<Tag> tags = new HashSet<>(tagRepository.findAllById(dto.getTagIds()));
        task.setTags(tags);

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
