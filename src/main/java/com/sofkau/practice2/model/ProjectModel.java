package com.sofkau.practice2.model;

import javax.persistence.*;

@Entity
@Table(name = "Projects")
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 25, nullable = false, unique = true)
    private String name;

    public ProjectModel() {
    }

    public ProjectModel(String name) {
        this.name = name;
    }

    public ProjectModel(Long id, String name) {
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
