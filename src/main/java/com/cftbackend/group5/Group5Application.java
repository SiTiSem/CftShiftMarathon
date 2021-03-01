package com.cftbackend.group5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Group5Application {

	public static void main(String[] args) {
		SpringApplication.run(Group5Application.class, args);
	}

}
