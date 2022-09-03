package com.gft.petshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class PetshopApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PetshopApplication.class, args);
	}

}
