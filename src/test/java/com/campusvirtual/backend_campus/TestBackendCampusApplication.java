package com.campusvirtual.backend_campus;

import org.springframework.boot.SpringApplication;

public class TestBackendCampusApplication {

	public static void main(String[] args) {
		SpringApplication.from(BackendCampusApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
