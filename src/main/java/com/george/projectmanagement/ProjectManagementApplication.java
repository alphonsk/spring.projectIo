package com.george.projectmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// calls packages not in this one, but we have to include thisone if we add this value
//@SpringBootApplication
@SpringBootApplication(scanBasePackages = {"com.george.projectmanagement", "com.george.util"})
public class ProjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

}
