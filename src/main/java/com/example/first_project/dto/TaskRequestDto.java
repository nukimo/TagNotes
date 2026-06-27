package com.example.first_project.dto;

import com.example.first_project.entity.TaskType;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class TaskRequestDto {
    private String title;
    private String description;
    private Set<Long> tagIds = new HashSet<>();
    private TaskType type;
}