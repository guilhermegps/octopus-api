package com.project.octopus.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableScheduling
@ComponentScan(basePackages = {"com.project.octopus"})
@EntityScan(basePackages = "com.project.octopus.*.domain.entity")
@EnableJpaRepositories(basePackages = "com.project.octopus.*.repositories")
@SpringBootApplication
public class OctopusApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OctopusApiApplication.class, args);
	}

}
