package com.example.first_project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagRequestDto {

    @NotBlank(message = "Tag name cannot be empty")
    private String name;
}
