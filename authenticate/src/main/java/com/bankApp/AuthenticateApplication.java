package com.bankApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.bankApp")
@ComponentScan("com.bankApp")

public class AuthenticateApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthenticateApplication.class, args);

    }

}