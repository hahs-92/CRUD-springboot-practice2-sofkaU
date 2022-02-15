package com.sofkau.practice2.repository;

import com.sofkau.practice2.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends JpaRepository<ProjectModel, Long> {
}
