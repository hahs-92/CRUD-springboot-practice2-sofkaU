package com.sofkau.practice2.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RoleDTO {
    private Long id;

    @NotBlank
    @Size(max = 15)
    private String name;

    public RoleDTO() {
    }

    public RoleDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleDTO(String name) {
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
