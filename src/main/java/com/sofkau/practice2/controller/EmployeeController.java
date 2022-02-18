package com.sofkau.practice2.controller;


import com.sofkau.practice2.dto.EmployeeDTO;
import com.sofkau.practice2.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/employees")
public class EmployeeController {
   private final IEmployeeService iEmployeeService;

    public EmployeeController(IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@RequestBody EmployeeDTO employee) {
        try {
            return new ResponseEntity<>(iEmployeeService.create(employee), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        try {
            return new ResponseEntity<>(iEmployeeService.getAll(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable Long id) {
        try {
            EmployeeDTO project = iEmployeeService.getById(id);

            return new ResponseEntity<>(project, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@RequestBody EmployeeDTO project, @PathVariable Long id) {
        try {
            EmployeeDTO projectUpdate = iEmployeeService.update(project, id);
            return new ResponseEntity<>(projectUpdate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        try {
            iEmployeeService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
