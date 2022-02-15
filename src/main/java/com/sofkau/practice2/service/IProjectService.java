package com.sofkau.practice2.service;

import com.sofkau.practice2.dto.ProjectDTO;
import javax.validation.Valid;
import java.util.List;

public interface IProjectService {
    public ProjectDTO create(@Valid ProjectDTO project);
    public List<ProjectDTO> getAll();
    public ProjectDTO getById(Long id);
    public ProjectDTO update(@Valid ProjectDTO project, Long id);
    public void delete(Long id);
}
