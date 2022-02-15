package com.sofkau.practice2;

import com.sofkau.practice2.model.EmployeeModel;
import com.sofkau.practice2.repository.IEmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
//dependiendo del perfil(dev-prod)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeRepositoryTest {
    private final IEmployeeRepository iEmployeeRepository;

    @Autowired
    public EmployeeRepositoryTest(IEmployeeRepository iEmployeeRepository) {
        this.iEmployeeRepository = iEmployeeRepository;
    }

    @Test
    public void saveEmployee() {
        EmployeeModel jest = new EmployeeModel("Jess", "Jonson", "emp123");
        EmployeeModel jinx  = new EmployeeModel("Jinx", "Lol", "emp666");

        iEmployeeRepository.save(jest);
        iEmployeeRepository.save(jinx);

        iEmployeeRepository.flush();

        assertEquals(2, iEmployeeRepository.findAll().size());
    }
}
