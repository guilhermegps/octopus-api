package com.project.octopus.auth.repositories;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.project.octopus.application.configs.DataJpaTestConfig;

@ActiveProfiles({"test", "data-jpa-test"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = DataJpaTestConfig.class)
@DataJpaTest
class UserRepositoryTest {
	
	@Autowired
    private UserRepository repository;
	
	@Test
    void findOneByUsernameAndEnabled_returnRecord() {
        // when
        var result = repository.findOneByUsernameAndEnabled("admin", Boolean.TRUE);

        // then
        assertTrue(result.isPresent());
    }

}
