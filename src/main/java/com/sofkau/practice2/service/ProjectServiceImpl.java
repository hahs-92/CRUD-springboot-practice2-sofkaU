package com.sofkau.practice2.service;

import com.sofkau.practice2.dto.ProjectDTO;
import com.sofkau.practice2.model.ProjectModel;
import com.sofkau.practice2.repository.IProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

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
        List<ProjectModel> listProjectEntity = iProjectRepository.findAll();
        return listProjectEntity.stream()
                .map( project -> modelMapper.map(project, ProjectDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getById(Long id) {
        ProjectModel projectEntity = iProjectRepository.findById(id).get();
        return modelMapper.map(projectEntity, ProjectDTO.class);
    }

    @Override
    public ProjectDTO update(ProjectDTO project, Long id) {
        return iProjectRepository.findById(id)
                .map(user -> {
                    user.setName(project.getName());
                    return modelMapper.map(iProjectRepository.save(user), ProjectDTO.class);
                }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        iProjectRepository.deleteById(id);
    }
}
