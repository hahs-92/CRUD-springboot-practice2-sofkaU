package com.sofkau.practice2.service;


import com.sofkau.practice2.dto.RoleDTO;

import javax.validation.Valid;
import java.util.List;

public interface IRoleService {
    public RoleDTO create(@Valid RoleDTO role);
    public List<RoleDTO> getAll();
}
