package com.sofkau.practice2.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDTO {
    private Long id;

    @NotBlank
    @Size(max = 25)
    private String firstName;

    @NotBlank
    @Size(max = 25)
    private String lastName;

    private RoleDTO role;

    private List<ProjectDTO> projects = new ArrayList<>();


    public EmployeeDTO() {
    }


    public EmployeeDTO(String firstName, String lastName, RoleDTO role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public EmployeeDTO(Long id, String firstName, String lastName, RoleDTO role, List<ProjectDTO> projects) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.projects = projects;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }
}
