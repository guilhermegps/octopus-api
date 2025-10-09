package com.project.octopus.application.configs;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Profile("data-jpa-test")
@Configuration
@EntityScan(basePackages = "com.project.octopus.*.domain.entity")
@EnableJpaRepositories(basePackages = "com.project.octopus.*.repositories")
public class DataJpaTestConfig {

}
