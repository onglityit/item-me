package com.darren.springsecuritytraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringSecurityTrainingApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityTrainingApp.class, args);
    }
}
