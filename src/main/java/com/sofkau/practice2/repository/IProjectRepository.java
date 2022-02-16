package com.sofkau.practice2.repository;

import com.sofkau.practice2.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectRepository extends JpaRepository<ProjectModel, Long> {
    ProjectModel findByName(String name);

    @Query("select p from Project p where p.id in :ids")
    List<ProjectModel> findByProjects(@Param("ids") List<Long> ids);
}
