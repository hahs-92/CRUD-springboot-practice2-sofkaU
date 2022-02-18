package com.sofkau.practice2.repository;

import com.sofkau.practice2.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    //Optional<EmployeeModel> findByEmployeeId(String employeeId);
    List<EmployeeModel> findByLastName(String lastName);
}
