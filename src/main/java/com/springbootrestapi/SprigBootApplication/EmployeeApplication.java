package com.springbootrestapi.SprigBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeApplication {

	public static void main(String args[]) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
}
