package com.sofkau.practice2.service;

import com.sofkau.practice2.dto.EmployeeDTO;
import com.sofkau.practice2.model.EmployeeModel;
import com.sofkau.practice2.repository.IEmployeeRepository;
import com.sofkau.practice2.repository.IProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
@Validated
public class EmployeeServiceImpl implements IEmployeeService{
    private final IEmployeeRepository iEmployeeRepository;
    private final ModelMapper mapper;

    @Autowired
    public EmployeeServiceImpl(
            IEmployeeRepository iEmployeeRepository,
            ModelMapper mapper
    ) {
        this.iEmployeeRepository = iEmployeeRepository;
        this.mapper = mapper;
    }


    @Override
    public EmployeeDTO create(EmployeeDTO employee) {
        EmployeeModel employeeEntity = mapper.map(employee, EmployeeModel.class);

       /* List<Long> idsProjects = new ArrayList<>();
        for(ProjectDTO project:employee.getProjects()){
            idsProjects.add(project.getId());
        }*/

        //employeeEntity.setProjects(iProjectRepository.findByProjects(idsProjects));

        employeeEntity = iEmployeeRepository.save(employeeEntity);
        return mapper.map(employeeEntity, EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> getAll() {
        List<EmployeeModel> listEmployees = iEmployeeRepository.findAll();
        return List.of(mapper.map(listEmployees, EmployeeDTO.class));
    }

    @Override
    public EmployeeDTO getById(Long id) {
        EmployeeModel employeeEntity = iEmployeeRepository.findById(id).get();
        return mapper.map(employeeEntity, EmployeeDTO.class);
    }

   /* @Override
    public EmployeeDTO getByEmployeeId(String employeeId) {
        EmployeeModel employeeEntity = iEmployeeRepository.findByEmployeeId(employeeId).get();
        return mapper.map(employeeEntity, EmployeeDTO.class);
    }*/

    @Override
    public EmployeeDTO update(EmployeeDTO employee, Long id) {
        return iEmployeeRepository.findById(id)
                .map(empl -> {
                    empl.setFirstName(employee.getFirstName());
                    empl.setLastName(employee.getLastName());
                    //empl.setRole(employee.getRole());
                    //empl.setProjects(employee.setProjects());

                    return mapper.map(iEmployeeRepository.save(empl),EmployeeDTO.class);
                }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        iEmployeeRepository.deleteById(id);
    }
}
