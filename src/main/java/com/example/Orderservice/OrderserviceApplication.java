package com.example.Orderservice;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OrderserviceApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure().load(); // Load environment variables from .env file
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue())); // Set system properties from environment variables and set them
		SpringApplication.run(OrderserviceApplication.class, args);
	}

}
