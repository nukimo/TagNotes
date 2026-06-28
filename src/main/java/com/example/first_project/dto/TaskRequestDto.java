package com.example.first_project.dto;

import com.example.first_project.entity.TaskType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class TaskRequestDto {
    @NotBlank(message = "Title cannot be empty")
    private String title;
    private String description;
    private Set<Long> tagIds = new HashSet<>();
    private TaskType type;
    private LocalDateTime deadline;

}