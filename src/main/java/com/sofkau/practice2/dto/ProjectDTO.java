package com.sofkau.practice2.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProjectDTO {
    private Long id;

    @NotBlank
    @Size(max = 25)
    private String name;

    public ProjectDTO() {
    }

    public ProjectDTO(String name) {
        this.name = name;
    }

    public ProjectDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
