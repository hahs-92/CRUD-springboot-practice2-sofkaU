package com.sofkau.practice2.repository;

import com.sofkau.practice2.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<RoleModel, Long> {
}
