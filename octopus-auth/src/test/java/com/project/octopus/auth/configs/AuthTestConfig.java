package com.project.octopus.auth.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
@ComponentScan(basePackages = "com.project.octopus.auth")
public class AuthTestConfig {

}
