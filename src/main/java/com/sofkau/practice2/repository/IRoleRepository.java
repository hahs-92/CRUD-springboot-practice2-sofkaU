package com.sofkau.practice2.repository;

import com.sofkau.practice2.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<RoleModel, Long> {
}
