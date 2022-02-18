package com.sofkau.practice2.service;


import com.sofkau.practice2.dto.EmployeeDTO;

import javax.validation.Valid;
import java.util.List;

public interface IEmployeeService {
    public EmployeeDTO create(@Valid EmployeeDTO employee);
    public List<EmployeeDTO> getAll();
    public EmployeeDTO getById(Long id);
    //public EmployeeDTO getByEmployeeId(String employeeId);
    public EmployeeDTO update(@Valid EmployeeDTO employee, Long id);
    public void delete(Long id);
}
