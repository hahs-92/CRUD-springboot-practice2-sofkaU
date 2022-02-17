package com.sofkau.practice2.controller;

import com.sofkau.practice2.dto.ProjectDTO;
import com.sofkau.practice2.service.IProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: 16/02/22 Cambiar el service 

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final IProjectService iProjectService;

    public EmployeeController(IProjectService iProjectService) {
        this.iProjectService = iProjectService;
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> create(@RequestBody ProjectDTO project) {
        try {
            return new ResponseEntity<>(iProjectService.create(project), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAll() {
        try {
            return new ResponseEntity<>(iProjectService.getAll(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getById(@PathVariable Long id) {
        try {
            ProjectDTO project = iProjectService.getById(id);

            if(project.getId() == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(project, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> update(@RequestBody ProjectDTO project, @PathVariable Long id) {
        try {
            ProjectDTO projectUpdate = iProjectService.update(project, id);

            if(projectUpdate.getId() == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(projectUpdate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        try {
            iProjectService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
