package com.sofkau.practice2.service;

import com.sofkau.practice2.dto.ProjectDTO;
import com.sofkau.practice2.model.ProjectModel;
import com.sofkau.practice2.repository.IProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class ProjectServiceImpl implements IProjectService {
    private final IProjectRepository iProjectRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectServiceImpl(IProjectRepository iProjectRepository, ModelMapper modelMapper) {
        this.iProjectRepository = iProjectRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ProjectDTO create(ProjectDTO project) {
        ProjectModel projectEntity = modelMapper.map(project, ProjectModel.class);
        projectEntity = iProjectRepository.save(projectEntity);
        return  modelMapper.map(projectEntity, ProjectDTO.class);
    }

    @Override
    public List<ProjectDTO> getAll() {
        List<ProjectModel> listProjectModel = iProjectRepository.findAll();
        return List.of(modelMapper.map(listProjectModel,ProjectDTO.class ));
    }

    @Override
    public ProjectDTO getById(Long id) {
        ProjectModel projectEntity = iProjectRepository.findById(id).get();
        return modelMapper.map(projectEntity, ProjectDTO.class);
    }

    @Override
    public ProjectDTO update(ProjectDTO project, Long id) {
        ProjectModel projectEntity = iProjectRepository.findById(id).get();
        projectEntity.setName(project.getName());

        return  modelMapper.map(projectEntity, ProjectDTO.class);
    }

    @Override
    public void delete(Long id) {
        iProjectRepository.deleteById(id);
    }
}
