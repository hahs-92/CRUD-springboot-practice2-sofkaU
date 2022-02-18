package com.sofkau.practice2.model;

import javax.persistence.*;

@Entity
@Table(name = "Roles")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 15, nullable = false, unique = true)
    private String name;

    public RoleModel() {
    }

    public RoleModel(String name) {
        this.name = name;
    }

    public RoleModel(Long id, String name) {
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
