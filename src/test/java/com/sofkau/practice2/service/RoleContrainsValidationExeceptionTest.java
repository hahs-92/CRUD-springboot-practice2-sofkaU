package com.sofkau.practice2.service;

import com.sofkau.practice2.dto.RoleDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RoleContrainsValidationExeceptionTest {
    private final RoleServiceImpl roleService;

    public RoleContrainsValidationExeceptionTest(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @Test
    public void contraintsValidationExceptionTest() {

        assertThrows(ConstraintViolationException.class, () -> {
            roleService.create(new RoleDTO(null));
        });

        assertThrows(ConstraintViolationException.class, () -> {
            roleService.create(new RoleDTO(""));
        });

        assertThrows(ConstraintViolationException.class, () -> {
            roleService.create(new RoleDTO("hjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkljkjk"));
        });
    }

    @Test
    public void createRoleOk() {
        RoleDTO role = roleService.create(new RoleDTO("ADMIN"));

        assertNotNull(role);
        assertEquals("ADMIN", role.getName());
        assertNotNull(role.getId());
    }
}
