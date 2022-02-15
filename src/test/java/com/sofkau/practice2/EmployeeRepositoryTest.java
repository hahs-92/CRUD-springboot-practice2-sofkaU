package com.sofkau.practice2;

import com.sofkau.practice2.model.EmployeeModel;
import com.sofkau.practice2.model.ProjectModel;
import com.sofkau.practice2.model.RoleModel;
import com.sofkau.practice2.repository.IEmployeeRepository;
import com.sofkau.practice2.repository.IProjectRepository;
import com.sofkau.practice2.repository.IRoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
//dependiendo del perfil(dev-prod)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeRepositoryTest {
    private final IEmployeeRepository iEmployeeRepository;
    private final IRoleRepository iRoleRepository;
    private final IProjectRepository iProjectRepository;

    @Autowired
    public EmployeeRepositoryTest(
            IEmployeeRepository iEmployeeRepository,
            IRoleRepository iRoleRepository,
            IProjectRepository iProjectRepository
    ) {
        this.iEmployeeRepository = iEmployeeRepository;
        this.iRoleRepository = iRoleRepository;
        this.iProjectRepository = iProjectRepository;
    }

    @Test
    public void saveEmployee() {
        RoleModel admin = new RoleModel("ADMIN");
        RoleModel dev = new RoleModel("DEV");

        admin = iRoleRepository.save(admin);
        dev = iRoleRepository.save(dev);

        ProjectModel project1 = new ProjectModel("project1");
        ProjectModel project2 = new ProjectModel("project2");
        ProjectModel project3 = new ProjectModel("project3");

        project1 = iProjectRepository.save(project1);
        project2 = iProjectRepository.save(project2);
        project3 = iProjectRepository.save(project3);

        EmployeeModel jest = new EmployeeModel("Jess", "Jonson", "emp123", admin);
        EmployeeModel jinx  = new EmployeeModel("Jinx", "Lol", "emp666", dev);

        jest.getProjects().add(project1);
        jest.getProjects().add(project2);
        jinx.getProjects().add(project1);
        jinx.getProjects().add(project2);
        jinx.getProjects().add(project3);

        iEmployeeRepository.save(jest);
        iEmployeeRepository.save(jinx);

        iEmployeeRepository.flush();

        EmployeeModel emp123 = iEmployeeRepository.findByEmployeeId("emp123").get();

        assertEquals("Jess", emp123.getFirstName());
        assertEquals(2, iEmployeeRepository.findAll().size());
        assertEquals(admin, emp123.getRole());
    }
}
