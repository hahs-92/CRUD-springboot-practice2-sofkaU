package com.sofkau.practice2.service;

import com.sofkau.practice2.dto.RoleDTO;
import com.sofkau.practice2.model.RoleModel;
import com.sofkau.practice2.repository.IRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class RoleServiceImpl implements IRoleService{
    private final IRoleRepository iRoleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleServiceImpl(
            IRoleRepository iRoleRepository,
            ModelMapper modelMapper
    ) {
        this.iRoleRepository = iRoleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RoleDTO create(RoleDTO role) {
        RoleModel roleEntity = modelMapper.map(role, RoleModel.class);
        roleEntity = iRoleRepository.save(roleEntity);
        return  modelMapper.map(roleEntity, RoleDTO.class);
    }

    @Override
    public List<RoleDTO> getAll() {
        List<RoleModel> listRolesEntity = iRoleRepository.findAll();

        return listRolesEntity.stream().map(role -> modelMapper.map(role, RoleDTO.class))
                .collect(Collectors.toList());

    }
}
