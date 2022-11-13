package com.eventoapp.evento.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;

@EnableJpaRepositories(basePackages = "com.eventoapp.repository")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}
	
	@GetMapping("/")
	public String Idex() {
		return "Lucas Gabriel Oliveira Da Silva";
	}
}

